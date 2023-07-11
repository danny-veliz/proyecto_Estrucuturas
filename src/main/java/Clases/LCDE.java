/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Usuario
 */
public class LCDE<E> implements List<E>,Iterable<E> {
    private  Node<E> first;
    private Node<E> last;
    private int size;
    
    
    public LCDE(){
        this.first = null;
        this.last=null;
        this.size=0;
    }

    @Override
    public int size() {
        return this.size;
    }

    public  Node<E> getFirst() {
        return first;
    }

    public void setFirst(Node<E> first) {
        this.first = first;
    }
    public void setLast(Node<E> last){
        this.last=last;
    }
    public Node<E> getLast(){
        return last;
    }
    
    @Override
    public boolean isEmpty() {
        return  first == null;
    }


    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
    
    public E obtenerSiguiente(E e){
        Node<E> viajero=first;
        for (int i=0; i<this.size;i++) {
            if(viajero.getContent().equals(e)){
                return viajero.getNext().getContent();
            }
            viajero=viajero.getNext();
        }
        return null;
    }
    
    
    public E obtenerPrevio(E e){
        Node<E> viajero=first;
        for (int i=0; i<this.size;i++) {
            if(viajero.getContent().equals(e)){
                return viajero.getPrevious().getContent();
            }
            viajero=viajero.getNext();
        }
        return null;
    }

    @Override
     public String toString() {
        String result = "{";
        if(this.size()==1)
            return result +first+" }";
        Node<E> p;
        for (p = first; p != null && !p.getNext().equals(first); p = p.getNext()) {

            result += p.getContent() + ", ";
        }
        result = result.substring(0, result.length() - 2);
        return result + "}";
    }
       
    
    

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void replaceAll(UnaryOperator<E> operator) {
        List.super.replaceAll(operator); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void sort(Comparator<? super E> c) {
        List.super.sort(c); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    
   
    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Spliterator<E> spliterator() {
        return List.super.spliterator(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public <T> T[] toArray(IntFunction<T[]> generator) {
        return List.super.toArray(generator); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public boolean removeIf(Predicate<? super E> filter) {
        return List.super.removeIf(filter); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public Stream<E> stream() {
        return List.super.stream(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public Stream<E> parallelStream() {
        return List.super.parallelStream(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    
    @Override
    public E remove(int index) {
        Node<E> viajero=first;
        for (int i=0; i<this.size;i++) {
            if(i== index){
                Node<E>newPrevious=viajero.getPrevious();
                Node<E>newNext=viajero.getNext();
                newPrevious.setNext(newNext);
                newNext.setPrevious(newPrevious);
                this.size--;
                return viajero.getContent();
            }
            viajero=viajero.getNext();
        }
        return null;
    }

    @Override
    public int indexOf(Object o){
        Node<E> viajero=first;
        for (int i=0; i<this.size;i++) {
            if(viajero.getContent().equals(o)){
                return i;
            }
            viajero=viajero.getNext();
        }
        return -1;
    }
    
    @Override
    public E set(int index, E element) {
        Node<E> viajero=first;
        Node<E> nuevo= new Node(element);
        for (int i=0; i<this.size;i++) {
            if(i== index){
                Node<E>newPrevious=viajero.getPrevious();
                Node<E>newNext=viajero.getNext();
                nuevo.setNext(newNext);
                nuevo.setPrevious(newPrevious);
                newPrevious.setNext(nuevo);
                newNext.setPrevious(nuevo);
                return viajero.getContent();
            }
            viajero=viajero.getNext();
        }
        return null;
    }
    
    
    @Override
    public boolean addAll(Collection<? extends E> c) {
        if(c.isEmpty())
            return false;
        for(E e:c){
            this.add(e);
        }
        return true;
    }
    
    
    @Override
    public boolean add(E e) {
        if (e == null) {
            return false;
        }
        Node<E> nuevo = new Node<>(e);
        if (this.isEmpty()) {
            this.first = nuevo;
        } else {
            this.last.setNext(nuevo);
            nuevo.setPrevious(last);
        }
        nuevo.setNext(first);
        this.first.setPrevious(nuevo);
        this.last = nuevo;
        this.size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        Node<E> viajero=first;
        Node<E> remover=new Node(o);
        for (int i=0; i<this.size;i++) {
            if(viajero.equals(remover)){
                Node<E>newPrevious=viajero.getPrevious();
                Node<E>newNext=viajero.getNext();
                newPrevious.setNext(newNext);
                newNext.setPrevious(newPrevious);
                this.size--;
                return true;
            } 
            viajero=viajero.getNext();
        }
        return false;
    }
    
    @Override
    public boolean contains(Object o) {
        Node<E> viajero=first;
        for (int i=0; i<this.size;i++) {
            if(viajero.getContent().equals(o)){
                return true;
            }
            viajero=viajero.getNext();
        }
        return false;
    }
    
     @Override
    public Iterator<E> iterator() {
        
        Iterator<E> it = new Iterator<E>() {
            Node<E> cursor = first;
            @Override
            public boolean hasNext() {
                return cursor != null;
            }

            @Override
            public E next() {
                E e = cursor.getContent();
                cursor = cursor.getNext().getNext();
                return e;
            }
        };
        
        return it;
        
        
        }
    
    
    @Override
    public E get(int index) {
        Node<E> viajero=first;
        for (int i=0; i<this.size;i++) {
            if(i== index){
                return viajero.getContent();
            }
            viajero=viajero.getNext();
        }
        return null;
    }
    
    @Override
    public void add(int index, E element) {
        if(element==null||index>=this.size)
            return;
        else if(index==0){
            addFirst(element);
        }
        else if(index==this.size-1){
            add(element);
        }else{
            Node<E> nuevo=new Node(element);
            Node<E> viajero=first;
            for (int i=0; i<this.size;i++) {
                if(i== index){
                    nuevo.setPrevious(viajero.getPrevious());
                    nuevo.setNext(viajero);
                    viajero.setPrevious(nuevo);
                    this.size++;
                    return;                
                }
                viajero=viajero.getNext();
            }
        }
    }
    
   

    @Override
    public void clear() {
        this.size=0;
        this.first=null;
        this.last=null;
    }

    public boolean addFirst(E element) {
        if (element == null) {
            return false;
        }
        Node<E> nuevo = new Node<>(element);
        
        if (this.isEmpty()) {
            nuevo.setNext(nuevo);
            nuevo.setPrevious(nuevo);
            this.first = nuevo;
            this.last=nuevo;
        }else{
            nuevo.setNext(first);
            nuevo.setPrevious(last);
            last.setNext(nuevo);
            first.setPrevious(nuevo);
        }
        
        this.first = nuevo;
        this.size++;
        return true;
    }


    public void removeFirst() {
        if (this.isEmpty())
            return;
        if(this.size==1){
            this.clear();
        }else if(this.size>1){
            this.first=this.first.getNext();
            this.last.setNext(first);
            this.first.setPrevious(last);
        }
        this.size--;
    }

    public void removeLast() {
        if (this.isEmpty())
            return;
        if(this.size==1){
            this.clear();
        }else if(this.size>1){
            this.last=this.last.getPrevious();
            this.first.setPrevious(this.last);
            this.last.setNext(first);
        }
        this.size--;
    }


}
