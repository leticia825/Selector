import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Defines a library of selection methods on Collections.
 *
 * @author Leticia Garcia
 * @version 1.17.2021
 *
 */
public final class Selector {

   // Constructor
   private Selector() { }


   /**
    * Returns the minimum value in the Collection coll as defined by the
    * Comparator comp. If either coll or comp is null, this method throws an
    * IllegalArgumentException. If coll is empty, this method throws a
    * NoSuchElementException. This method will not change coll in any way.
    *
    * @param coll    the Collection from which the minimum is selected
    * @param comp    the Comparator that defines the total order on T
    * @return        the minimum value in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T min(Collection<T> coll, Comparator<T> comp) {
      
      if ((coll == null) || (comp == null) || coll.size() == 0) {
         throw new IllegalArgumentException();
      }
   
      if (coll.isEmpty()) {
         throw new NoSuchElementException();
      }
     
      Iterator itr = coll.iterator();
      T min = (T)itr.next();
      
      while (itr.hasNext()) {
         T some = (T)itr.next();         
         
         if (comp.compare(some, min) < 0) {
            min = some;
         }
      }
         
      return min; 
   }
   
   /**
    * Selects the maximum value in the Collection coll as defined by the
    * Comparator comp. If either coll or comp is null, this method throws an
    * IllegalArgumentException. If coll is empty, this method throws a
    * NoSuchElementException. This method will not change coll in any way.
    *
    * @param coll    the Collection from which the maximum is selected
    * @param comp    the Comparator that defines the total order on T
    * @return        the maximum value in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T max(Collection<T> coll, Comparator<T> comp) {
      
      if ((coll == null) || (comp == null || coll.size() == 0)) {
         throw new IllegalArgumentException();
      }
   
      if (coll.isEmpty()) {
         throw new NoSuchElementException();
      }
      
      Iterator itr = coll.iterator();
      T max = (T)itr.next();
      
      while (itr.hasNext()) {
         T some = (T)itr.next();
            
         if (comp.compare(some, max) > 0) {
            max = some;
         }
      }
      
      return max;
   }

   /**
    * Selects the kth minimum value from the Collection coll as defined by the
    * Comparator comp. If either coll or comp is null, this method throws an
    * IllegalArgumentException. If coll is empty or if there is no kth minimum
    * value, this method throws a NoSuchElementException. This method will not
    * change coll in any way.
    *
    * @param coll    the Collection from which the kth minimum is selected
    * @param k       the k-selection value
    * @param comp    the Comparator that defines the total order on T
    * @return        the kth minimum value in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T kmin(Collection<T> coll, int k, Comparator<T> comp) {
      
      if ((coll == null) || (comp == null)) {
         throw new IllegalArgumentException();
      }
   
      if (coll.isEmpty() || k > coll.size() || k <= 0) {
         throw new NoSuchElementException();
      }
      
      Iterator itr = coll.iterator();
      ArrayList thing = new ArrayList<T>();
        
      T x = (T)itr.next();
      thing.add(x);
      
      while (itr.hasNext()) {
         T y = (T)itr.next();
         
         if (!thing.contains(y)) {
            thing.add(y);
         }
      }
      
      java.util.Collections.sort(thing, comp);
      
      if (k > thing.size()) {
         throw new NoSuchElementException();
      }
      
      T kmin = (T)thing.get(k - 1);
      
      return kmin;
   }

   /**
    * Selects the kth maximum value from the Collection coll as defined by the
    * Comparator comp. If either coll or comp is null, this method throws an
    * IllegalArgumentException. If coll is empty or if there is no kth maximum
    * value, this method throws a NoSuchElementException. This method will not
    * change coll in any way.
    *
    * @param coll    the Collection from which the kth maximum is selected
    * @param k       the k-selection value
    * @param comp    the Comparator that defines the total order on T
    * @return        the kth maximum value in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T kmax(Collection<T> coll, int k, Comparator<T> comp) {
      
      if ((coll == null) || (comp == null)) {
         throw new IllegalArgumentException();
      }
   
      if (coll.isEmpty() || k > coll.size() || k <= 0) {
         throw new NoSuchElementException();
      }
      
      Iterator itr = coll.iterator();
      ArrayList thing = new ArrayList<T>();
         
      T x = (T)itr.next();
      thing.add(x);
      
      while (itr.hasNext()) {
         T y = (T)itr.next();
            
         if (!thing.contains(y)) {
            thing.add(y);
         }
      }
      
      java.util.Collections.sort(thing, comp);
      
      if (k > thing.size()) {
         throw new NoSuchElementException();
      }
         
      T kmax = (T)thing.get(thing.size() - k);
      
      return kmax;
   }


   /**
    * Returns a new Collection containing all the values in the Collection coll
    * that are greater than or equal to low and less than or equal to high, as
    * defined by the Comparator comp. The returned collection must contain only
    * these values and no others. The values low and high themselves do not have
    * to be in coll. Any duplicate values that are in coll must also be in the
    * returned Collection. If no values in coll fall into the specified range or
    * if coll is empty, this method throws a NoSuchElementException. If either
    * coll or comp is null, this method throws an IllegalArgumentException. This
    * method will not change coll in any way.
    *
    * @param coll    the Collection from which the range values are selected
    * @param low     the lower bound of the range
    * @param high    the upper bound of the range
    * @param comp    the Comparator that defines the total order on T
    * @return        a Collection of values between low and high
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> Collection<T> range(Collection<T> coll, T low, T high,
                                                     Comparator<T> comp) {
      if ((coll == null) || (comp == null)) {
         throw new IllegalArgumentException();
      }
   
      if (coll.isEmpty()) {
         throw new NoSuchElementException();
      }
   
      if (!(comp.compare(low, high) <= 0)) {
         throw new NoSuchElementException();
      }
      
      Iterator itr = coll.iterator();
      ArrayList<T> thing = new ArrayList<T>();
      
      while (itr.hasNext()) {
         T some = (T)itr.next();
         
         if ((comp.compare(some, high) <= 0) && (comp.compare(some, low) >= 0)) {
            thing.add(some);
         }
      }
      
      if (thing.size() == 0) {
         throw new NoSuchElementException(); 
      }
      
      return thing;
   }

   /**
    * Returns the smallest value in the Collection coll that is greater than
    * or equal to key, as defined by the Comparator comp. The value of key
    * does not have to be in coll. If coll or comp is null, this method throws
    * an IllegalArgumentException. If coll is empty or if there is no
    * qualifying value, this method throws a NoSuchElementException. This
    * method will not change coll in any way.
    *
    * @param coll    the Collection from which the ceiling value is selected
    * @param key     the reference value
    * @param comp    the Comparator that defines the total order on T
    * @return        the ceiling value of key in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T ceiling(Collection<T> coll, T key, Comparator<T> comp) {
      
      if ((coll == null) || (comp == null)) {
         throw new IllegalArgumentException();
      }
   
      if (coll.isEmpty()) {
         throw new NoSuchElementException();
      }
      
      Iterator itr = coll.iterator();
      Collection<T> collList = Selector.range(coll, key, Selector.max(coll, comp), comp);
      
      if (collList.size() == 0) {
         throw new NoSuchElementException();
      }         
      T ceiling = Selector.min(collList, comp);
      
      return ceiling;
   }

   /**
    * Returns the largest value in the Collection coll that is less than
    * or equal to key, as defined by the Comparator comp. The value of key
    * does not have to be in coll. If coll or comp is null, this method throws
    * an IllegalArgumentException. If coll is empty or if there is no
    * qualifying value, this method throws a NoSuchElementException. This
    * method will not change coll in any way.
    *
    * @param coll    the Collection from which the floor value is selected
    * @param key     the reference value
    * @param comp    the Comparator that defines the total order on T
    * @return        the floor value of key in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
    
   public static <T> T floor(Collection<T> coll, T key, Comparator<T> comp) {
      if ((coll == null) || (comp == null)) {
         throw new IllegalArgumentException();
      }
   
      if (coll.isEmpty()) {
         throw new NoSuchElementException();
      }
      
      else {
         Iterator itr = coll.iterator();
         Collection<T> collList = Selector.range(coll, Selector.min(coll, comp), key, comp);
         
         if (collList.size() == 0) {
            throw new NoSuchElementException();
         }
      
         T floor = Selector.max(collList, comp);
      
         return floor;
      }
   }
}