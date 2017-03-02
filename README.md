Here you can find a test for a bug reproducing.

The thing is that, when I'm trying to save entity (Person) with valid number of child entities (Cat) everything is ok, but
then I change collection size to make parent entity invalid and expect test to fail with validation exception.But this does
not happen and test passes.

