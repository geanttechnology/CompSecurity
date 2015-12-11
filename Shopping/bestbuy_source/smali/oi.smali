.class public final Loi;
.super Ljava/lang/Object;

# interfaces
.implements Lpa;
.implements Lpc;


# instance fields
.field private a:Lcom/google/android/gms/ads/AdView;

.field private b:Lop;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static a(Landroid/content/Context;Loy;Landroid/os/Bundle;Landroid/os/Bundle;)Lom;
    .locals 4

    const/4 v1, 0x1

    new-instance v2, Lon;

    invoke-direct {v2}, Lon;-><init>()V

    invoke-interface {p1}, Loy;->a()Ljava/util/Date;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {v2, v0}, Lon;->a(Ljava/util/Date;)Lon;

    :cond_0
    invoke-interface {p1}, Loy;->b()I

    move-result v0

    if-eqz v0, :cond_1

    invoke-virtual {v2, v0}, Lon;->a(I)Lon;

    :cond_1
    invoke-interface {p1}, Loy;->c()Ljava/util/Set;

    move-result-object v0

    if-eqz v0, :cond_2

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v2, v0}, Lon;->a(Ljava/lang/String;)Lon;

    goto :goto_0

    :cond_2
    invoke-interface {p1}, Loy;->d()Landroid/location/Location;

    move-result-object v0

    if-eqz v0, :cond_3

    invoke-virtual {v2, v0}, Lon;->a(Landroid/location/Location;)Lon;

    :cond_3
    invoke-interface {p1}, Loy;->e()Z

    move-result v0

    if-eqz v0, :cond_4

    invoke-static {p0}, Laca;->a(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Lon;->b(Ljava/lang/String;)Lon;

    :cond_4
    const-string v0, "tagForChildDirectedTreatment"

    invoke-virtual {p3, v0}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v0

    const/4 v3, -0x1

    if-eq v0, v3, :cond_5

    const-string v0, "tagForChildDirectedTreatment"

    invoke-virtual {p3, v0}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v0

    if-ne v0, v1, :cond_7

    move v0, v1

    :goto_1
    invoke-virtual {v2, v0}, Lon;->a(Z)Lon;

    :cond_5
    if-eqz p2, :cond_8

    :goto_2
    const-string v0, "gw"

    invoke-virtual {p2, v0, v1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    const-string v0, "mad_hac"

    const-string v3, "mad_hac"

    invoke-virtual {p3, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p2, v0, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    const-string v0, "adJson"

    invoke-virtual {p3, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_6

    const-string v0, "_ad"

    const-string v3, "adJson"

    invoke-virtual {p3, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p2, v0, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    :cond_6
    const-string v0, "_noRefresh"

    invoke-virtual {p2, v0, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    const-class v0, Loi;

    invoke-virtual {v2, v0, p2}, Lon;->a(Ljava/lang/Class;Landroid/os/Bundle;)Lon;

    invoke-virtual {v2}, Lon;->a()Lom;

    move-result-object v0

    return-object v0

    :cond_7
    const/4 v0, 0x0

    goto :goto_1

    :cond_8
    new-instance p2, Landroid/os/Bundle;

    invoke-direct {p2}, Landroid/os/Bundle;-><init>()V

    goto :goto_2
.end method


# virtual methods
.method public a()V
    .locals 2

    const/4 v1, 0x0

    iget-object v0, p0, Loi;->a:Lcom/google/android/gms/ads/AdView;

    if-eqz v0, :cond_0

    iget-object v0, p0, Loi;->a:Lcom/google/android/gms/ads/AdView;

    invoke-virtual {v0}, Lcom/google/android/gms/ads/AdView;->a()V

    iput-object v1, p0, Loi;->a:Lcom/google/android/gms/ads/AdView;

    :cond_0
    iget-object v0, p0, Loi;->b:Lop;

    if-eqz v0, :cond_1

    iput-object v1, p0, Loi;->b:Lop;

    :cond_1
    return-void
.end method

.method public a(Landroid/content/Context;Lpb;Landroid/os/Bundle;Loo;Loy;Landroid/os/Bundle;)V
    .locals 4

    new-instance v0, Lcom/google/android/gms/ads/AdView;

    invoke-direct {v0, p1}, Lcom/google/android/gms/ads/AdView;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Loi;->a:Lcom/google/android/gms/ads/AdView;

    iget-object v0, p0, Loi;->a:Lcom/google/android/gms/ads/AdView;

    new-instance v1, Loo;

    invoke-virtual {p4}, Loo;->b()I

    move-result v2

    invoke-virtual {p4}, Loo;->a()I

    move-result v3

    invoke-direct {v1, v2, v3}, Loo;-><init>(II)V

    invoke-virtual {v0, v1}, Lcom/google/android/gms/ads/AdView;->setAdSize(Loo;)V

    iget-object v0, p0, Loi;->a:Lcom/google/android/gms/ads/AdView;

    const-string v1, "pubid"

    invoke-virtual {p3, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/google/android/gms/ads/AdView;->setAdUnitId(Ljava/lang/String;)V

    iget-object v0, p0, Loi;->a:Lcom/google/android/gms/ads/AdView;

    new-instance v1, Loj;

    invoke-direct {v1, p0, p2}, Loj;-><init>(Loi;Lpb;)V

    invoke-virtual {v0, v1}, Lcom/google/android/gms/ads/AdView;->setAdListener(Lol;)V

    iget-object v0, p0, Loi;->a:Lcom/google/android/gms/ads/AdView;

    invoke-static {p1, p5, p6, p3}, Loi;->a(Landroid/content/Context;Loy;Landroid/os/Bundle;Landroid/os/Bundle;)Lom;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/google/android/gms/ads/AdView;->a(Lom;)V

    return-void
.end method

.method public a(Landroid/content/Context;Lpd;Landroid/os/Bundle;Loy;Landroid/os/Bundle;)V
    .locals 2

    new-instance v0, Lop;

    invoke-direct {v0, p1}, Lop;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Loi;->b:Lop;

    iget-object v0, p0, Loi;->b:Lop;

    const-string v1, "pubid"

    invoke-virtual {p3, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lop;->a(Ljava/lang/String;)V

    iget-object v0, p0, Loi;->b:Lop;

    new-instance v1, Lok;

    invoke-direct {v1, p0, p2}, Lok;-><init>(Loi;Lpd;)V

    invoke-virtual {v0, v1}, Lop;->a(Lol;)V

    iget-object v0, p0, Loi;->b:Lop;

    invoke-static {p1, p4, p5, p3}, Loi;->a(Landroid/content/Context;Loy;Landroid/os/Bundle;Landroid/os/Bundle;)Lom;

    move-result-object v1

    invoke-virtual {v0, v1}, Lop;->a(Lom;)V

    return-void
.end method

.method public b()V
    .locals 1

    iget-object v0, p0, Loi;->a:Lcom/google/android/gms/ads/AdView;

    if-eqz v0, :cond_0

    iget-object v0, p0, Loi;->a:Lcom/google/android/gms/ads/AdView;

    invoke-virtual {v0}, Lcom/google/android/gms/ads/AdView;->c()V

    :cond_0
    return-void
.end method

.method public c()V
    .locals 1

    iget-object v0, p0, Loi;->a:Lcom/google/android/gms/ads/AdView;

    if-eqz v0, :cond_0

    iget-object v0, p0, Loi;->a:Lcom/google/android/gms/ads/AdView;

    invoke-virtual {v0}, Lcom/google/android/gms/ads/AdView;->d()V

    :cond_0
    return-void
.end method

.method public d()Landroid/view/View;
    .locals 1

    iget-object v0, p0, Loi;->a:Lcom/google/android/gms/ads/AdView;

    return-object v0
.end method

.method public e()V
    .locals 1

    iget-object v0, p0, Loi;->b:Lop;

    invoke-virtual {v0}, Lop;->a()V

    return-void
.end method
