#include <stdio.h>
#include <string.h>

void main(){
char str[20]="Hello World";
char resand[20]="";
char resor[20]="";
char resxor[20]="";

for(int i=0;i<strlen(str);i++){
	resand[i]=str[i]&127;
	resor[i]=str[i]|127;
	resxor[i]=str[i]^127;

	
}
printf("result of and operation:%s \n",resand);
printf("result of or operation:%s \n",resor);
printf("result of xor operation:%s \n",resxor);

}

