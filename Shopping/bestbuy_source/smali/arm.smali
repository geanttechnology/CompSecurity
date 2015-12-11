.class Larm;
.super Ljava/lang/Object;


# direct methods
.method public static a(Lwk;)Lwk;
    .locals 2

    new-instance v1, Lwk;

    invoke-direct {v1}, Lwk;-><init>()V

    iget v0, p0, Lwk;->a:I

    iput v0, v1, Lwk;->a:I

    iget-object v0, p0, Lwk;->k:[I

    invoke-virtual {v0}, [I->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [I

    iput-object v0, v1, Lwk;->k:[I

    iget-boolean v0, p0, Lwk;->l:Z

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lwk;->l:Z

    iput-boolean v0, v1, Lwk;->l:Z

    :cond_0
    return-object v1
.end method
