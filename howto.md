клонируем на комп
```
git clone https://github.com/kursor1337/KotlinAsFirst2020`
cd KotlinAsFirst2020
```
добавляем апстрим
```
git remote add upstream-my https://github.com/kursor1337/KotlinAsFirst2021
git fetch upstream-my
```
создаем ветку backport и заодно переходим в нее
```
git checkout -b backport
```
берем все коммиты с того что указан по конечный и перекидываем в текущую ветку
```
git cherry-pick d535f3592006b8f2593c9f881d72c05164aadc13...FETCH_HEAD
```
добавляем второй апстрим (своей пары)
```
git remote add upstream-theirs https://github.com/FeelingIcy/KotlinAsFirst2021
git fetch upstream-theirs
```
переходим в ветку master
```
git checkout  master
```
мерджим
```
git merge upstream-theirs/master
```
заливаем все что нам выдает git remote -v в файл remotes
```
git remote -v > remotes
```
добавляем remotes в гит чтобы он за ним следил
```
git add remotes
```
коммитим и пушим
```
git commit -m "yeah"
git push
```
ПРОФИТ
