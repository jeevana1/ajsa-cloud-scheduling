package org.cloudbus.cloudsim;

public class MinMin {

	/**
	 * @param args
	 */
	 public double[][] assignjobsmin(double[][] completiontime,int m,int n)
	    {
	        int i,j,b=0,flag=0,y=0;
	        double resultmin[][]=new double[4000][8000];
	        double completiontimeNew[][]=new double[1000][1000];
	        double[][] JA=new double[1000][1000];
	            for(i=0;i<m;i++)
	            {
	                for(j=0;j<n;j++)
	                {
	                   
	                    completiontimeNew[i][j]=completiontime[i][j];
	                    JA[i][j]=completiontime[i][j];
	                }
	               
	            }
	      
	        do
	        {       
	            int pos[]=new int[1000];
	            double min_val[]=new double[1000];
	            for(j=0;j<n;j++)
	            {
	                while(JA[0][j]==0 && j<(n-1))
	                {
	                  j++;
	                }
	              
	                pos[j]=0;
	                min_val[j]=JA[0][j];
	                for(i=0;i<m;i++)
	                {
	                    if(JA[i][j]<min_val[j] && JA[i][j]!=0)
	                    {
	                        min_val[j]=JA[i][j];
	                        pos[j]=i;
	                    }
	                }
	                                       
	            }
	           
	            //To find min completion time on which machine
	            int position;
	            double min;
	            int k=0;
	            while(min_val[k]!=0 && k<(n-1))
	            {
	                  k++;
	            }
	            min=min_val[k];
	            position=pos[k];
	            for(int e=0;e<n;e++)
	            {
	                if(min_val[e]!=0)
	                {
	                    if(min_val[e]<min)
	                    {
	                        min=min_val[e];
	                        position=pos[e];
	                    }
	                }
	               
	            }
	                  
	            //To find the task corresponding to min completion time on m/c
	            int pos_job=0;
	            for(i=0;i<n;i++)
	            {
	                if(JA[position][i]==min)
	                {
	                    pos_job=i;
	                }
	            }
	            
	           //To store the result of each step
	                resultmin[y][0]=pos_job;
	                resultmin[y][1]=position;
	                resultmin[y][2]=min;
	                y++;
	                
	            double xx;
	             //To Update the values of other task on machine specified by position
	            for(i=0;i<n;i++)
	            {
	                xx=0;
	                if(JA[position][i]!=99999)
	                {
	                    //System.out.println("Time: "+completiontime[position][i]);
	                    xx=completiontime[position][i];
	                    xx+=min;
	                    JA[position][i]=xx;
	                    //System.out.println("Updated value:"+xx+ " on m/c :" +position+ " for task: "+i);
	                }
	                
	            }
	            
	            
	            //Delete the task under pos_job.
	            for(i=0;i<n;i++)
	            {
	                JA[i][pos_job]=99999;
	                
	            }
	         
	          for(b=0;b<n;b++)
	           {
	               if(JA[1][b]!=99999)
	               {
	                   flag=1;
	                   break;
	               }
	               else
	                   flag=0;
	           }
	       }while(flag==1);
	        
	        
	        return resultmin;
	    }
	            
	}
