package org.cloudbus.cloudsim;

public class Ajsacost {

	/**
	 * @param args
	 */
	  public double[][] assignjobsajsacost(double[][] completiontime,int m,int n,int[] priority1)
	    {
	         int i,j,y=0;
	         
	        double resultcost[][]=new double[2000][2000];
	        double completiontimeNew[][]=new double[1000][1000];
	        
	        double[][] JA=new double[1000][1000];
	        int priority[]=new int[100];
	          for(i=0;i<m;i++)
	            {
	                for(j=0;j<n;j++)
	                {
	                   
	                    completiontimeNew[i][j]=completiontime[i][j];
	                    JA[i][j]=completiontime[i][j];
	                    
	                }
	               
	            }
	         for(i=0;i<n;i++)
	            {
	                priority[i]=priority1[i];
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
	            
	            //To find highest priority (smallest value) task
	            
	            int minprior=priority[0];
	            int pos =0;
	            for(i=0;i<n;i++)
	            {
	                if(priority[i]<minprior && priority[i]!=99999)
	                {
	                    minprior=priority[i];
	                    pos=i;
	                }
	            }
	              priority[pos]=99999; 
	              
	            //To fing min. completion time of task with highest priority pointed by minposition  and pos rep. machine
	            int position=0;  
	            double min=completiontimeNew[0][pos];
	            for(i=0;i<m;i++)
	            {
	                if(completiontimeNew[i][pos]<min)
	                {
	                    min=completiontimeNew[i][pos];
	                    position=i;
	                }
	            }
	          
	            
	                //To store the result of each step
	                resultcost[y][0]=pos;
	                resultcost[y][1]=position;
	                resultcost[y][2]=min;
	                y++;
	                
	                //System.out.println("Result of AJSA-Cost Based");
	                //System.out.println("Task\tMachine\tCompletion time");
	                 for(i=0;i<n;i++)
	                 {
	                 //   System.out.println(resultcost[i][1]+"\t"+resultcost[i][2]+"\t"+resultcost[i][3]);
	                 }
	                                
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
	            // System.out.println("Updation");
	            for(i=0;i<m;i++)
	            {
	                for(j=0;j<n;j++)
	                {
	                 // System.out.print(completiontime[i][j]+"\t");
	                    
	                }
	               // System.out.println();
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
	        
	    return resultcost;
	    }

	    
	}