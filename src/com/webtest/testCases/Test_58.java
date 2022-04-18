package com.webtest.testCases;

import com.sun.mail.handlers.image_gif;

import bsh.This;

public class Test_58 {
	public int[] twoSum (int[] nums, int target) {
		int[] tar= {} ;
		int a = 0;
		int b = 0;
		for(int i = 0;i<nums.length;i++) {
			a = nums[i];
			for(int j=i;j<nums.length ;j++) {
				b=nums[j];
				if(a+b==target) {
					a =i+1;
					b=j+1;
					int[] num= {i,j};
					tar = num;
					
					
				}
			}
			
		}
		return tar;
        // write code here
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2};
		int target = 3;
		 new Test_58().twoSum(nums, target);

	}

}
