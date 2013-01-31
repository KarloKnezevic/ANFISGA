rules = dlmread('learnedRules.txt');

X1 = rules(1,1:2);
X2 = rules(4,1:2);
X3 = rules(7,1:2);

Y1 = rules(1,3:4);
Y2 = rules(2,3:4);
Y3 = rules(3,3:4);

x = 0:0.001:10;

subplot(2,1,1);

hold on;
y = trimf(x, [X1(1)-X1(2) X1(1) X1(1)+X1(2)]);
plot(x,y,'r');
y = trimf(x, [X2(1)-X2(2) X2(1) X2(1)+X2(2)]);
plot(x,y,'g');
y = trimf(x, [X3(1)-X3(2) X3(1) X3(1)+X3(2)]);
plot(x,y,'b');
xlabel('x');
ylabel('Lambda(x)');
legend(num2str(X1),num2str(X2),num2str(X3),-1);
title('X Membership');

subplot(2,1,2);

hold on;
y = trimf(x, [Y1(1)-Y1(2) Y1(1) Y1(1)+Y1(2)]);
plot(x,y,'r');
y = trimf(x, [Y2(1)-Y2(2) Y2(1) Y2(1)+Y2(2)]);
plot(x,y,'g');
y = trimf(x, [Y3(1)-Y3(2) Y3(1) Y3(1)+Y3(2)]);
plot(x,y,'b');
xlabel('y');
ylabel('Lambda(y)');
legend(num2str(Y1),num2str(Y2),num2str(Y3),-1);
title('Y Membership');

print('-djpeg','XYMembership.jpg');
