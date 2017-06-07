$(function () {
	var chartindex = 0;
	
	var data = {
		labels: [],
		datasets: [{
			label: "CPU Temp",
			fill: false,
			data: [],
		}]
	};
	var option = {
		showLines: true	
	};
	
	var ctx = document.getElementById("myChart").getContext('2d');
	
	var myLineChart = new Chart(ctx,{
		type:'line',
		data:data,
		options:option
	});
	

	
    $("#testAddButton").click(function() {
    	var d = new Date();
    	myLineChart.data.datasets[0].data.push(Math.floor(Math.random() * 100));
    	var mlbl = d.toLocaleTimeString();
    	
    	if (myLineChart.data.labels.length > 10) {
        	myLineChart.data.datasets[0].data.shift();
    		myLineChart.data.labels.shift();
    	}
    	
    	chartindex++;
    	myLineChart.update();
    });
    
    $("#testRemoveButton").click(function() {
    	myLineChart.data.datasets[0].data.shift();
		myLineChart.data.labels.shift();
		
		chartindex--;
		myLineChart.update();
    });
    
    function stupid() {
    	alert("hi");
    }
    
    stupid();
});
