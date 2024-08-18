package railway;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("rawtypes")
public class Category implements Serializable {
    
    private ArrayList<Train> trainCategoryes ;

    public ArrayList<Train> getTrainCategoryes() {
        return trainCategoryes;
    }

    public void setTrainCategoryes(Train train,Files file) {
        this.trainCategoryes.add(train);
        
        file.saveCategory(trainCategoryes);
        

    }

    public void removetrainformca(Train train,Files file){
       
        
         for (Train each : trainCategoryes) {
             if (each.getId() == train.getId()) {
                 trainCategoryes.remove(each);
                  file.saveCategory(trainCategoryes);
             
                 break;

             }
            
         }
         
        
    }

    public Category(ArrayList<Train> trainCategoryes) {
        this.trainCategoryes = trainCategoryes;
    }

    
    
}