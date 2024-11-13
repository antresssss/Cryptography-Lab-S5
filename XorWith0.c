#include <stdio.h>
#include <string.h>

void main(){
char str[20]="Hello World";
char resxor[20]=" ";


for(int i=0;i<strlen(str);i++){
	resxor[i]=str[i]^0;	
}
printf("result of xor operation:%s \n",resxor);
}

