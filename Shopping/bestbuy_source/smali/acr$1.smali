.class final Lacr$1;
.super Landroid/os/AsyncTask;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lacr;->a(Ljava/lang/String;Landroid/content/Context;)Lacr;
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method


# virtual methods
.method protected varargs a([Ljava/lang/Void;)Ljava/lang/Void;
    .locals 2

    const/4 v1, 0x0

    :try_start_0
    invoke-static {}, Lacr;->f()Lov;

    move-result-object v0

    invoke-virtual {v0}, Lov;->a()V
    :try_end_0
    .catch Lps; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Lpt; {:try_start_0 .. :try_end_0} :catch_2

    :goto_0
    invoke-static {}, Lacr;->g()Ljava/util/concurrent/CountDownLatch;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    return-object v1

    :catch_0
    move-exception v0

    const/4 v0, 0x1

    invoke-static {v0}, Lacr;->a(Z)Z

    invoke-static {v1}, Lacr;->a(Lov;)Lov;

    goto :goto_0

    :catch_1
    move-exception v0

    invoke-static {v1}, Lacr;->a(Lov;)Lov;

    goto :goto_0

    :catch_2
    move-exception v0

    invoke-static {v1}, Lacr;->a(Lov;)Lov;

    goto :goto_0
.end method

.method protected synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lacr$1;->a([Ljava/lang/Void;)Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method
