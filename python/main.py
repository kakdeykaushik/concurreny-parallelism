from concurrent.futures import ProcessPoolExecutor, ThreadPoolExecutor

def cpu_heavy(x):
    print('I am', x)
    count = 0
    for i in range(10**7):
        count += i

 
def multithreading(func, args, workers):
    with ThreadPoolExecutor(workers) as ex:
        res = ex.map(func, args)
    return list(res)

def multiprocessing(func, args, workers):
    with ProcessPoolExecutor(workers) as ex:
        res = ex.map(func, args)
    return list(res)


# multithreading(cpu_heavy, range(8), 8)
multiprocessing(cpu_heavy, range(8), 8)


