rules = dlmread('learnedRules.txt');

xmin = 0;
xmax = 10;
step = 0.001;
ymin = 0;
ymax = 1;
rulesCount = size(rules);

%on one pic goes 4 rules
rowsGraphs = 4; 
colsGraphs = 3;

cnt = 0;
written = 1;
for i = 1:rulesCount(:,1)
  
    %graph for 1. membership function
    cnt = cnt+1;
    subplot(rowsGraphs, colsGraphs, cnt);
    x = xmin:step:xmax;
    y = trimf(x, [rules(i,2)-rules(i,1) rules(i,2) rules(i,2)+rules(i,1)]);
    plot(x,y);
    axis([xmin xmax ymin ymax]);
    title('Lambda X');
    xlabel('x');
    ylabel('Lambda(x)');
    
    
    %graph for 2. membership function
    cnt = cnt+1;
    subplot(rowsGraphs, colsGraphs, cnt);
    x = xmin:step:xmax;
    y = trimf(x, [rules(i,3)-rules(i,4) rules(i,3) rules(i,3)+rules(i,4)]);
    plot(x,y);
    axis([xmin xmax ymin ymax]);
    title('Lambda Y');
    xlabel('y');
    ylabel('Lambda(y)');
   
    
    %graph for conclusion
    cnt = cnt+1;
    subplot(rowsGraphs, colsGraphs, cnt);
    x = xmin:step:xmax;
    %plot(x, rules(i,5), 'r', x, rules(i,6), 'g', x, rules(i,7), 'b');
    plot(x, rules(i,7), 'b');
    title('Conclusion');
    xlabel('x');
    ylabel('value');  
    
    if mod(cnt,rowsGraphs*colsGraphs) == 0 || i == rulesCount(1,1)
        cnt = 0;
        name = strcat('Rules',num2str(written),'.jpg');
        written = written+1;
        print('-djpeg',name);
        
        if written*rowsGraphs > rulesCount(1,1)
            clf();
        end;
    end;
end;












