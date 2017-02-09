package org.cloudbus.cloudsim;

public class MaxMin {

	/**
	 * @param args
	 */
	public double[][] assignjobsmax(double[][] completiontime,int m,int n)
    {
        int i,j;
        double resultmax[][]=new double[1000][1000];
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
        int b=0; 
        int flag=0;
        int y=0;
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
            double max;
            int k=0;
            while(min_val[k]!=0 && k<(n-1))
            {
                  k++;
            }
            max=min_val[k];
            position=pos[k];
            for(int e=0;e<n;e++)
            {
                if(min_val[e]!=0)
                {
                    if(min_val[e]>max)
                    {
                        max=min_val[e];
                        position=pos[e];
                    }
                }
               
            }
            
            //To find the task corresponding to min completion time on m/c
            int pos_job=0;
            for(i=0;i<n;i++)
            {
                if(JA[position][i]==max)
                {
                    pos_job=i;
                }
            }
            
                //To store the result of each step
                resultmax[y][0]=pos_job;
                resultmax[y][1]=position;
                resultmax[y][2]=max;
                y++;
                
            double xx;
             //To Update the values of other task on machine specified by position
            for(i=0;i<n;i++)
            {
                xx=0;
                if(JA[position][i]!=0)
                {
                    //System.out.println("Time: "+completiontime[position][i]);
                    xx=completiontime[position][i];
                    xx+=max;
                    JA[position][i]=xx;
                    //System.out.println("Updated value:"+xx+ " on m/c :" +position+ " for task: "+i);
                }
                
            }
            
            //Delete the task under pos_job.
            for(i=0;i<n;i++)
            {
                JA[i][pos_job]=0;
                
            }
          
          for(b=0;b<n;b++)
           {
               if(JA[0][b]!=0)
               {
                   flag=1;
                   break;
               }
               else
                   flag=0;
           }
       }while(flag==1);
        
        
        return resultmax;
    }
            
}

