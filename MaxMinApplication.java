import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import org.cloudbus.cloudsim.Cloudlet;
import org.cloudbus.cloudsim.CloudletSchedulerTimeShared;
import org.cloudbus.cloudsim.Datacenter;
import org.cloudbus.cloudsim.DatacenterBroker;
import org.cloudbus.cloudsim.DatacenterCharacteristics;
import org.cloudbus.cloudsim.Host;
import org.cloudbus.cloudsim.Log;
import org.cloudbus.cloudsim.Pe;
import org.cloudbus.cloudsim.Storage;
import org.cloudbus.cloudsim.UtilizationModel;
import org.cloudbus.cloudsim.UtilizationModelFull;
import org.cloudbus.cloudsim.Vm;
import org.cloudbus.cloudsim.VmAllocationPolicySimple;
import org.cloudbus.cloudsim.VmSchedulerTimeShared;
import org.cloudbus.cloudsim.core.CloudSim;
import org.cloudbus.cloudsim.provisioners.BwProvisionerSimple;
import org.cloudbus.cloudsim.provisioners.PeProvisionerSimple;
import org.cloudbus.cloudsim.provisioners.RamProvisionerSimple;


public class MaxMinApplication {

	/**
	 * @param args
	 */
	/** The cloudlet list. */
	private static List<Cloudlet> cloudletList;

	/** The vmList. */
	private static List<Vm> vmList;
      
    	private static List<Vm> createVM(int userId, int vms, int idShift) {
		//Creates a container to store VMs. This list is passed to the broker later
		LinkedList<Vm> list = new LinkedList<Vm>();
                LinkedList<Vm> list1 = new LinkedList<Vm>();
		//VM Parameters
		int pesNumber = 1; //number of cpus
		String vmm = "Xen"; //VMM name

		//create VMs
		Vm[] vm = new Vm[vms];

		
                vm[0] = new Vm(idShift + 0, userId, 25000, pesNumber, 512, 1000, 10000, vmm, new CloudletSchedulerTimeShared());
                list.add(vm[0]);

                vm[1] = new Vm(idShift + 1, userId, 15000, pesNumber, 1024, 1000, 10000, vmm, new CloudletSchedulerTimeShared());
                list.add(vm[1]);

                vm[2] = new Vm(idShift + 2, userId, 10000, pesNumber, 256, 1000, 5000, vmm, new CloudletSchedulerTimeShared());
                list.add(vm[2]);

                vm[3] = new Vm(idShift + 3, userId, 13000, pesNumber,256, 2000, 15000, vmm, new CloudletSchedulerTimeShared());
                list.add(vm[3]);

                vm[4] = new Vm(idShift + 4, userId, 5000, pesNumber, 1024,1000, 7000, vmm, new CloudletSchedulerTimeShared());
                list.add(vm[4]);

                return list;
        }


	private static List<Cloudlet> createCloudlet(int userId, int cloudlets, int idShift){
		// Creates a container to store Cloudlets
		LinkedList<Cloudlet> list = new LinkedList<Cloudlet>();

		//cloudlet parameters
		UtilizationModel utilizationModel = new UtilizationModelFull();

		Cloudlet[] cloudlet = new Cloudlet[cloudlets];

                cloudlet[0] = new Cloudlet(idShift + 0, 30000, 1, 200, 512, utilizationModel, utilizationModel, utilizationModel);
                cloudlet[0].setUserId(userId);
                list.add(cloudlet[0]);
                
                cloudlet[1] = new Cloudlet(idShift + 1, 20000, 1, 200, 256, utilizationModel, utilizationModel, utilizationModel);
                cloudlet[1].setUserId(userId);
                list.add(cloudlet[1]);
                
                cloudlet[2] = new Cloudlet(idShift + 2, 35000, 1, 200, 512, utilizationModel, utilizationModel, utilizationModel);
                cloudlet[2].setUserId(userId);
                list.add(cloudlet[2]);
                
                cloudlet[3] = new Cloudlet(idShift + 3, 55000, 1, 200, 256, utilizationModel, utilizationModel, utilizationModel);
                cloudlet[3].setUserId(userId);
                list.add(cloudlet[3]);
                
                cloudlet[4] = new Cloudlet(idShift + 4, 50500, 1, 200, 512, utilizationModel, utilizationModel, utilizationModel);
                cloudlet[4].setUserId(userId);
                list.add(cloudlet[4]);
                
                cloudlet[5] = new Cloudlet(idShift + 5, 28000, 1, 200, 1024, utilizationModel, utilizationModel, utilizationModel);
                cloudlet[5].setUserId(userId);
                list.add(cloudlet[5]);
                
                cloudlet[6] = new Cloudlet(idShift + 6, 50000, 1, 200, 512, utilizationModel, utilizationModel, utilizationModel);
                cloudlet[6].setUserId(userId);
                list.add(cloudlet[6]);
                
                cloudlet[7] = new Cloudlet(idShift + 7, 53000, 1, 200, 256, utilizationModel, utilizationModel, utilizationModel);
                cloudlet[7].setUserId(userId);
                list.add(cloudlet[7]);
                
                cloudlet[8] = new Cloudlet(idShift + 8, 15000, 1, 200, 512, utilizationModel, utilizationModel, utilizationModel);
                cloudlet[8].setUserId(userId);
                list.add(cloudlet[8]);
		
                cloudlet[9] = new Cloudlet(idShift + 9, 20000, 1, 200, 512, utilizationModel, utilizationModel, utilizationModel);
                cloudlet[9].setUserId(userId);
                list.add(cloudlet[9]);
                
                cloudlet[10] = new Cloudlet(idShift + 10, 30000, 1, 200, 512, utilizationModel, utilizationModel, utilizationModel);
                cloudlet[10].setUserId(userId);
                list.add(cloudlet[10]);
                
                cloudlet[11] = new Cloudlet(idShift + 11, 22000, 1, 200, 256, utilizationModel, utilizationModel, utilizationModel);
                cloudlet[11].setUserId(userId);
                list.add(cloudlet[11]);
                
                cloudlet[12] = new Cloudlet(idShift + 12, 35000, 1, 200, 512, utilizationModel, utilizationModel, utilizationModel);
                cloudlet[12].setUserId(userId);
                list.add(cloudlet[12]);
                
                cloudlet[13] = new Cloudlet(idShift + 13, 20000, 1, 200, 1024, utilizationModel, utilizationModel, utilizationModel);
                cloudlet[13].setUserId(userId);
                list.add(cloudlet[13]);
                
                cloudlet[14] = new Cloudlet(idShift + 14, 55000, 1, 200, 512, utilizationModel, utilizationModel, utilizationModel);
                cloudlet[14].setUserId(userId);
                list.add(cloudlet[14]);
              
                cloudlet[15] = new Cloudlet(idShift + 15, 43000, 1, 200, 256, utilizationModel, utilizationModel, utilizationModel);
                cloudlet[15].setUserId(userId);
                list.add(cloudlet[15]);
                
                cloudlet[16] = new Cloudlet(idShift + 16, 25000, 1, 200, 1024, utilizationModel, utilizationModel, utilizationModel);
                cloudlet[16].setUserId(userId);
                list.add(cloudlet[16]);
                
                cloudlet[17] = new Cloudlet(idShift + 17, 35000, 1, 200, 256, utilizationModel, utilizationModel, utilizationModel);
                cloudlet[17].setUserId(userId);
                list.add(cloudlet[17]);
                
                cloudlet[18] = new Cloudlet(idShift + 18, 51000, 1, 200, 512, utilizationModel, utilizationModel, utilizationModel);
                cloudlet[18].setUserId(userId);
                list.add(cloudlet[18]);
                
                cloudlet[19] = new Cloudlet(idShift + 19, 41000, 1, 200, 512, utilizationModel, utilizationModel, utilizationModel);
                cloudlet[19].setUserId(userId);
                list.add(cloudlet[19]);
                
                cloudlet[20] = new Cloudlet(idShift + 20, 30000, 1, 200, 512, utilizationModel, utilizationModel, utilizationModel);
                cloudlet[20].setUserId(userId);
                list.add(cloudlet[20]);
                
                cloudlet[21] = new Cloudlet(idShift + 21, 20000, 1, 200, 256, utilizationModel, utilizationModel, utilizationModel);
                cloudlet[21].setUserId(userId);
                list.add(cloudlet[21]);
                
                cloudlet[22] = new Cloudlet(idShift + 22, 35000, 1, 200, 512, utilizationModel, utilizationModel, utilizationModel);
                cloudlet[22].setUserId(userId);
                list.add(cloudlet[22]);
                
                cloudlet[23] = new Cloudlet(idShift + 23, 55000, 1, 200, 256, utilizationModel, utilizationModel, utilizationModel);
                cloudlet[23].setUserId(userId);
                list.add(cloudlet[23]);
                
                cloudlet[24] = new Cloudlet(idShift + 24, 50500, 1, 200, 512, utilizationModel, utilizationModel, utilizationModel);
                cloudlet[24].setUserId(userId);
                list.add(cloudlet[24]);
                
                cloudlet[25] = new Cloudlet(idShift + 25, 28000, 1, 200, 1024, utilizationModel, utilizationModel, utilizationModel);
                cloudlet[25].setUserId(userId);
                list.add(cloudlet[25]);
                
                cloudlet[26] = new Cloudlet(idShift + 26, 50000, 1, 200, 512, utilizationModel, utilizationModel, utilizationModel);
                cloudlet[26].setUserId(userId);
                list.add(cloudlet[26]);
                
                cloudlet[27] = new Cloudlet(idShift + 27, 53000, 1, 200, 256, utilizationModel, utilizationModel, utilizationModel);
                cloudlet[27].setUserId(userId);
                list.add(cloudlet[27]);
                
                cloudlet[28] = new Cloudlet(idShift + 28, 15000, 1, 200, 512, utilizationModel, utilizationModel, utilizationModel);
                cloudlet[28].setUserId(userId);
                list.add(cloudlet[28]);
		
                cloudlet[29] = new Cloudlet(idShift + 29, 20000, 1, 200, 512, utilizationModel, utilizationModel, utilizationModel);
                cloudlet[29].setUserId(userId);
                list.add(cloudlet[29]);
                
                return list;
	}


	////////////////////////// STATIC METHODS ///////////////////////

	/**
	 * Creates main() to run this example
	 */
	public static void main(String[] args) throws IOException {
		
                
                int i;
                double resultajsa[][]=new double[4000][4000];
                int[] task=new int[100];
                int[] machine=new int[100];
                              
                double xx[][]=new double[100][100];
          
               
                    
                
		try {
			// First step: Initialize the CloudSim package. It should be called
			// before creating any entities.
			int num_user = 2;   // number of grid users
			Calendar calendar = Calendar.getInstance();
			boolean trace_flag = false;  // mean trace events

			// Initialize the CloudSim library
			CloudSim.init(num_user, calendar, trace_flag);

                    	// Second step: Create Datacenters
			//Datacenters are the resource providers in CloudSim. We need at list one of them to run a CloudSim simulation
			@SuppressWarnings("unused")
			Datacenter datacenter0 = createDatacenter("Datacenter_0");
			@SuppressWarnings("unused")
			Datacenter datacenter1 = createDatacenter("Datacenter_1");

			//Third step: Create Broker
			DatacenterBroker broker = createBroker("Broker_0");
			int brokerId = broker.getId();
        
                        //Fourth step: Create VMs and Cloudlets and send them to broker
                        int m=5,n=30;
			vmList = createVM(brokerId, m, 0); //creating 5 vms
			cloudletList = createCloudlet(brokerId, n, 0); // creating 30 cloudlets

			broker.submitVmList(vmList);
			broker.submitCloudletList(cloudletList);
                        
                        Cloudlet cloudlet=cloudletList.get(0);
    
                        xx=cloudlet.expectedCompletionNew(cloudletList, vmList, m, n); //refer Cloudlet.java

                        resultajsa=broker.assignTaskToMaxMin(xx,m, n);
                    
                        for(i=0;i<n;i++)
                        {
                            task[i]=(int) resultajsa[i][0];
                            machine[i]=(int) resultajsa[i][1];
                        }
                        for(i=0;i<n;i++)
                        {
                            broker.bindCloudletToVm(task[i],machine[i]); //refer DatacenterBroker.java
                        }
    			
                        // Fifth step: Starts the simulation
                        CloudSim.startSimulation();
 
			// Final step: Print results when simulation is over
			List<Cloudlet> newList = broker.getCloudletReceivedList();

			CloudSim.stopSimulation();

                        printresultajsa(newList,resultajsa,m,n);
                        
                       
                      
		}
		catch (Exception e)
		{
			e.printStackTrace();
			Log.printLine("The simulation has been terminated due to an unexpected error");
		}
                
        
	}
        private static Datacenter createDatacenter(String name){

		// Here are the steps needed to create a PowerDatacenter:
		// 1. We need to create a list to store one or more
		//    Machines
		List<Host> hostList = new ArrayList<Host>();

		// 2. A Machine contains one or more PEs or CPUs/Cores. Therefore, should
		//    create a list to store these PEs before creating
		//    a Machine.
		List<Pe> peList1 = new ArrayList<Pe>();
                int mips = 100000;

		// 3. Create PEs and add these into the list.
		//for a quad-core machine, a list of 4 PEs is required:
		peList1.add(new Pe(0, new PeProvisionerSimple(mips))); // need to store Pe id and MIPS Rating
		peList1.add(new Pe(1, new PeProvisionerSimple(mips)));
		peList1.add(new Pe(2, new PeProvisionerSimple(mips)));
		peList1.add(new Pe(3, new PeProvisionerSimple(mips)));

		//Another list, for a dual-core machine
		List<Pe> peList2 = new ArrayList<Pe>();

		peList2.add(new Pe(0, new PeProvisionerSimple(mips)));
		peList2.add(new Pe(1, new PeProvisionerSimple(mips)));

                //4. Create Hosts with its id and list of PEs and add them to the list of machines
		int hostId=0;
		int ram = 16384; //host memory (MB)
		long storage = 1000000; //host storage
		int bw = 10000;

		hostList.add(
    			new Host(
    				hostId,
    				new RamProvisionerSimple(ram),
    				new BwProvisionerSimple(bw),
    				storage,
    				peList1,
    				new VmSchedulerTimeShared(peList1)
    			)
    		); // This is our first machine

		hostId++;

		hostList.add(
    			new Host(
    				hostId,
    				new RamProvisionerSimple(ram),
    				new BwProvisionerSimple(bw),
    				storage,
    				peList1,
    				new VmSchedulerTimeShared(peList2)
    			)
    		); // Second machine

		// 5. Create a DatacenterCharacteristics object that stores the
		//    properties of a data center: architecture, OS, list of
		//    Machines, allocation policy: time- or space-shared, time zone
		//    and its price (G$/Pe time unit).
		String arch = "x86";      // system architecture
		String os = "Linux";          // operating system
		String vmm = "Xen";
		double time_zone = 10.0;         // time zone this resource located
		double cost = 3.0;              // the cost of using processing in this resource
		double costPerMem = 0.05;		// the cost of using memory in this resource
		double costPerStorage = 0.1;	// the cost of using storage in this resource
		double costPerBw = 0.1;			// the cost of using bw in this resource
		LinkedList<Storage> storageList = new LinkedList<Storage>();	//we are not adding SAN devices by now

		DatacenterCharacteristics characteristics = new DatacenterCharacteristics(
                arch, os, vmm, hostList, time_zone, cost, costPerMem, costPerStorage, costPerBw);

		// 6. Finally, we need to create a PowerDatacenter object.
		Datacenter datacenter = null;
		try {
			datacenter = new Datacenter(name, characteristics, new VmAllocationPolicySimple(hostList), storageList, 0);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return datacenter;
	}

	//We strongly encourage users to develop their own broker policies, to submit vms and cloudlets according
	//to the specific rules of the simulated scenario
	private static DatacenterBroker createBroker(String name){

		DatacenterBroker broker = null;
		try {
			broker = new DatacenterBroker(name);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return broker;
	}	
        
        private static void printresultajsa(List<Cloudlet> list,double[][] resultajsa,int m,int n)
        {
                 int i,j=0;
                 double comp[]=new double[1000];
                 double compajsatask[]=new double[1000];
                 
                  Cloudlet cloudlet=null;
                    
                  System.out.println("\nResult of AJSA");
                  System.out.println("Task\tMachine\tCompletion time");
                           
                                for(i=0;i<n;i++)
                                {
                                    cloudlet= list.get(i);
                                    if (cloudlet.getCloudletStatus() == Cloudlet.SUCCESS)
                                    {
                                       System.out.println(resultajsa[i][0]+"\t"+resultajsa[i][1]+"\t"+resultajsa[i][2]);
                                    }
                                }    
                  
                                //For consolidation of m/c and completion time
                                for(i=0;i<m;i++)
                                {
                                    for(j=0;j<n;j++)
                                    {
                                       if(resultajsa[j][1]==i)
                                       {
                                           comp[i]=resultajsa[j][2];
                                       }
                                    }
                                }
                                System.out.println("Consolidation");
                                System.out.println("Machine\tCompletion Time");
                                for(i=0;i<m;i++)
                                {
                                   System.out.println(i+"\t"+comp[i]);
                                }
                                
                                //To consolidate completion time for each task
                                for(i=0;i<n;i++)
                                {
                                    for(j=0;j<n;j++)
                                    {
                                       if(resultajsa[j][0]==i)
                                       {
                                       
                                           compajsatask[i]=resultajsa[j][2];
                                          
                                       }
                                      
                                    }
                               }
                               System.out.println("Consolidation of Completion time to each task on AJSA algorithm");
                               System.out.println("Task\tCompletion time");
                                for(i=0;i<n;i++)
                                {
                                   System.out.println(i+"\t"+compajsatask[i]);
                                } 
                                
             }

}
