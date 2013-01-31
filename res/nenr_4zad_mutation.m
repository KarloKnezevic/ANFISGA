mu1 = dlmread('average_3.2E-4_.txt');
mu2 = dlmread('average_0.0016_.txt');
mu3 = dlmread('average_0.016_.txt');
mu4 = dlmread('average_0.16_.txt');
mu5 = dlmread('average_0.8_.txt');

hold on;
plot(mu1(:,1),log10(mu1(:,2)), 'r');
plot(mu2(:,1),log10(mu2(:,2)), 'g');
plot(mu3(:,1),log10(mu3(:,2)), 'b');
plot(mu4(:,1),log10(mu4(:,2)), 'm');
plot(mu5(:,1),log10(mu5(:,2)), 'c');

xlabel('Generations');
ylabel('Log10(best individual fitness)');
title('The effect of mutation; Average fitness of best individual over 5 measurements');

error1 = mu1(size(mu1,1),2);
error2 = mu2(size(mu2,1),2);
error3 = mu3(size(mu3,1),2);
error4 = mu4(size(mu4,1),2);
error5 = mu5(size(mu5,1),2);
legend(num2str(error1), num2str(error2), num2str(error3), num2str(error4), num2str(error5));

print('-djpeg','mutation.jpg');
