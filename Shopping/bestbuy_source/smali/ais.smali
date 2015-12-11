.class public Lais;
.super Lrs;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lrs",
        "<",
        "Lair;",
        ">;"
    }
.end annotation


# instance fields
.field protected a:Lsc;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lsc",
            "<",
            "Lair;",
            ">;"
        }
    .end annotation
.end field

.field private final b:Landroid/app/Fragment;

.field private c:Landroid/app/Activity;

.field private final d:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Laiw;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/app/Fragment;)V
    .locals 1

    invoke-direct {p0}, Lrs;-><init>()V

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lais;->d:Ljava/util/List;

    iput-object p1, p0, Lais;->b:Landroid/app/Fragment;

    return-void
.end method

.method public static synthetic a(Lais;Landroid/app/Activity;)V
    .locals 0

    invoke-direct {p0, p1}, Lais;->a(Landroid/app/Activity;)V

    return-void
.end method

.method private a(Landroid/app/Activity;)V
    .locals 0

    iput-object p1, p0, Lais;->c:Landroid/app/Activity;

    invoke-virtual {p0}, Lais;->i()V

    return-void
.end method


# virtual methods
.method protected a(Lsc;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lsc",
            "<",
            "Lair;",
            ">;)V"
        }
    .end annotation

    iput-object p1, p0, Lais;->a:Lsc;

    invoke-virtual {p0}, Lais;->i()V

    return-void
.end method

.method public i()V
    .locals 4

    iget-object v0, p0, Lais;->c:Landroid/app/Activity;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lais;->a:Lsc;

    if-eqz v0, :cond_1

    invoke-virtual {p0}, Lais;->a()Lrr;

    move-result-object v0

    if-nez v0, :cond_1

    :try_start_0
    iget-object v0, p0, Lais;->c:Landroid/app/Activity;

    invoke-static {v0}, Laiv;->a(Landroid/content/Context;)I

    iget-object v0, p0, Lais;->c:Landroid/app/Activity;

    invoke-static {v0}, Lanf;->a(Landroid/content/Context;)Lakw;

    move-result-object v0

    iget-object v1, p0, Lais;->c:Landroid/app/Activity;

    invoke-static {v1}, Lsb;->a(Ljava/lang/Object;)Lry;

    move-result-object v1

    invoke-interface {v0, v1}, Lakw;->b(Lry;)Laju;

    move-result-object v0

    iget-object v1, p0, Lais;->a:Lsc;

    new-instance v2, Lair;

    iget-object v3, p0, Lais;->b:Landroid/app/Fragment;

    invoke-direct {v2, v3, v0}, Lair;-><init>(Landroid/app/Fragment;Laju;)V

    invoke-interface {v1, v2}, Lsc;->a(Lrr;)V

    iget-object v0, p0, Lais;->d:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Laiw;

    invoke-virtual {p0}, Lais;->a()Lrr;

    move-result-object v1

    check-cast v1, Lair;

    invoke-virtual {v1, v0}, Lair;->a(Laiw;)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Lps; {:try_start_0 .. :try_end_0} :catch_1

    goto :goto_0

    :catch_0
    move-exception v0

    new-instance v1, Lanl;

    invoke-direct {v1, v0}, Lanl;-><init>(Landroid/os/RemoteException;)V

    throw v1

    :cond_0
    :try_start_1
    iget-object v0, p0, Lais;->d:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V
    :try_end_1
    .catch Landroid/os/RemoteException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Lps; {:try_start_1 .. :try_end_1} :catch_1

    :cond_1
    :goto_1
    return-void

    :catch_1
    move-exception v0

    goto :goto_1
.end method
