package org.cloudbus.cloudsim;

public class ajsa {

	/**
	 * @param args
	 */
	 public double[][] assignjobsajsa(double[][] completiontime,int m,int n)
	    {
	         int i,j,y=0;
	         
	        double resultajsa[][]=new double[4000][4000];
	        double completiontimeNew[][]=new double[1000][1000];
	        double diff[][]=new double[4000][4000];
	        double[][] JA=new double[1000][1000];
	        
	          for(i=0;i<m;i++)
	            {
	                for(j=0;j<n;j++)
	                {
	                   
	                    completiontimeNew[i][j]=completiontime[i][j];
	                    JA[i][j]=completiontime[i][j];
	                    
	                }
	               
	            }
	            
	        int b=0; 
	        int flag=0;
	        double temp=0;  
	        do
	        {       
	           
	            for(i=0;i<m;i++)
	            {
	                for(j=0;j<n;j++)
	                {
	                   
	                    completiontimeNew[i][j]=JA[i][j];
	                                       
	                }
	               
	            }
	            //System.out.println("VAl");      
	            for(i=0;i<m;i++)
	            {
	                for(j=0;j<n;j++)
	                {
	                 
	              //      System.out.print(completiontimeNew[i][j]+"\t");
	                                     
	                }
	               //System.out.println();  
	            }
	           //Column wise sorting 
	             for(j=0;j<n;j++)
	             { 
	               for(i=0;i<m;i++)
	                {
	                    for(int k=i+1;k<m;k++)
	                    {
	                        if(completiontimeNew[i][j]>completiontimeNew[k][j])
	                        {
	            
	                            temp=completiontimeNew[k][j];
	                            completiontimeNew[k][j]=completiontimeNew[i][j];
	                            completiontimeNew[i][j]=temp;
	                        }
	                    }
	                }
	            }
	          //To find difference value
	            for(i=0;i<n;i++)
	            {
	                if(completiontimeNew[0][i]!=99999)
	                {
	                    diff[0][i]=completiontimeNew[1][i]-completiontimeNew[0][i];
	                }
	                else
	                {
	                    diff[0][i]=-1;
	                }
	            }
	            for(i=0;i<n;i++)
	            {
	                //System.out.println("Inside"+diff[1][i]);
	            }
	            
	            //System.out.println("outside");
	            //To get max. diff. valued task
	            int pos;
	            double max_val;//[]=new double[100];
	            pos=0;
	            max_val=diff[0][0];
	                
	            for(j=0;j<n;j++)
	            {              
	                    if(diff[0][j]>max_val && diff[0][j]!=-1)
	                    {
	                        max_val=diff[0][j];
	                        pos=j;
	    //                    System.out.println("Consolidation:"+diff[1][j]);
	                    }
	                    //System.out.println("Consolidation:"+diff[1][j]);
	             }
	            //To find min completion time on which machine
	            int position=0;
	            double min;
	            int k=1;
	           
	            min=JA[0][pos];
	           
	            for(int e=0;e<m;e++)
	            {
	                if(JA[e][pos]<min)
	                {
	                    min=JA[e][pos];
	                    position=e;
	            
	                }
	            }
	            
	                //To store the result of each step
	                resultajsa[y][0]=pos;
	                resultajsa[y][1]=position;
	                resultajsa[y][2]=min;
	                y++;
	            
	            double xx;
	             //To Update the values of other task on machine specified by position
	            for(i=0;i<n;i++)
	            {
	                xx=0;
	                if(JA[position][i]!=99999)
	                {
	            
	                    xx=completiontime[position][i];
	                    xx+=min;
	                    JA[position][i]=xx;
	            
	                }
	                
	            }
	            
	            
	            //Delete the task under pos.
	            for(i=0;i<n;i++)
	            {
	                JA[i][pos]=99999;
	                
	            }
	            
	          for(b=0;b<n;b++)
	           {
	               if(JA[0][b]!=99999)
	               {
	                   flag=1;
	                   break;
	               }
	               else
	                   flag=0;
	           }
	       }while(flag==1);
	        
	        
	    return resultajsa;
	    }
	    
	}