.class public Lajc;
.super Lrs;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lrs",
        "<",
        "Lajb;",
        ">;"
    }
.end annotation


# instance fields
.field protected a:Lsc;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lsc",
            "<",
            "Lajb;",
            ">;"
        }
    .end annotation
.end field

.field private final b:Landroid/view/ViewGroup;

.field private final c:Landroid/content/Context;

.field private final d:Lcom/google/android/gms/maps/StreetViewPanoramaOptions;

.field private final e:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Laix;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/view/ViewGroup;Landroid/content/Context;Lcom/google/android/gms/maps/StreetViewPanoramaOptions;)V
    .locals 1

    invoke-direct {p0}, Lrs;-><init>()V

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lajc;->e:Ljava/util/List;

    iput-object p1, p0, Lajc;->b:Landroid/view/ViewGroup;

    iput-object p2, p0, Lajc;->c:Landroid/content/Context;

    iput-object p3, p0, Lajc;->d:Lcom/google/android/gms/maps/StreetViewPanoramaOptions;

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
            "Lajb;",
            ">;)V"
        }
    .end annotation

    iput-object p1, p0, Lajc;->a:Lsc;

    invoke-virtual {p0}, Lajc;->i()V

    return-void
.end method

.method public i()V
    .locals 4

    iget-object v0, p0, Lajc;->a:Lsc;

    if-eqz v0, :cond_1

    invoke-virtual {p0}, Lajc;->a()Lrr;

    move-result-object v0

    if-nez v0, :cond_1

    :try_start_0
    iget-object v0, p0, Lajc;->c:Landroid/content/Context;

    invoke-static {v0}, Lanf;->a(Landroid/content/Context;)Lakw;

    move-result-object v0

    iget-object v1, p0, Lajc;->c:Landroid/content/Context;

    invoke-static {v1}, Lsb;->a(Ljava/lang/Object;)Lry;

    move-result-object v1

    iget-object v2, p0, Lajc;->d:Lcom/google/android/gms/maps/StreetViewPanoramaOptions;

    invoke-interface {v0, v1, v2}, Lakw;->a(Lry;Lcom/google/android/gms/maps/StreetViewPanoramaOptions;)Lakj;

    move-result-object v0

    iget-object v1, p0, Lajc;->a:Lsc;

    new-instance v2, Lajb;

    iget-object v3, p0, Lajc;->b:Landroid/view/ViewGroup;

    invoke-direct {v2, v3, v0}, Lajb;-><init>(Landroid/view/ViewGroup;Lakj;)V

    invoke-interface {v1, v2}, Lsc;->a(Lrr;)V

    iget-object v0, p0, Lajc;->e:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Laix;

    invoke-virtual {p0}, Lajc;->a()Lrr;

    move-result-object v1

    check-cast v1, Lajb;

    invoke-virtual {v1, v0}, Lajb;->a(Laix;)V
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
    iget-object v0, p0, Lajc;->e:Ljava/util/List;

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
