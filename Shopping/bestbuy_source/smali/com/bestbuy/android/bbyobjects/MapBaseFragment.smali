.class public Lcom/bestbuy/android/bbyobjects/MapBaseFragment;
.super Lcom/google/android/gms/maps/SupportMapFragment;
.source "SourceFile"

# interfaces
.implements Laiw;


# instance fields
.field private a:Laim;

.field private b:Lcom/bestbuy/android/base/BBYBaseFragment;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 19
    invoke-direct {p0}, Lcom/google/android/gms/maps/SupportMapFragment;-><init>()V

    .line 20
    return-void
.end method

.method public static a(Lcom/bestbuy/android/base/BBYBaseFragment;)Lcom/bestbuy/android/bbyobjects/MapBaseFragment;
    .locals 1

    .prologue
    .line 23
    new-instance v0, Lcom/bestbuy/android/bbyobjects/MapBaseFragment;

    invoke-direct {v0}, Lcom/bestbuy/android/bbyobjects/MapBaseFragment;-><init>()V

    .line 24
    iput-object p0, v0, Lcom/bestbuy/android/bbyobjects/MapBaseFragment;->b:Lcom/bestbuy/android/base/BBYBaseFragment;

    .line 25
    return-object v0
.end method


# virtual methods
.method public a()V
    .locals 0

    .prologue
    .line 36
    invoke-virtual {p0, p0}, Lcom/bestbuy/android/bbyobjects/MapBaseFragment;->a(Laiw;)V

    .line 37
    return-void
.end method

.method public a(Laim;)V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 49
    iput-object p1, p0, Lcom/bestbuy/android/bbyobjects/MapBaseFragment;->a:Laim;

    .line 50
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/MapBaseFragment;->a:Laim;

    if-eqz v0, :cond_0

    .line 51
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/MapBaseFragment;->a:Laim;

    invoke-virtual {v0}, Laim;->c()Lajh;

    move-result-object v0

    invoke-virtual {v0, v1}, Lajh;->a(Z)V

    .line 52
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/MapBaseFragment;->a:Laim;

    invoke-virtual {v0, v1}, Laim;->a(Z)V

    .line 54
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/MapBaseFragment;->b:Lcom/bestbuy/android/base/BBYBaseFragment;

    if-eqz v0, :cond_1

    .line 55
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/MapBaseFragment;->b:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->b_()V

    .line 56
    :cond_1
    return-void
.end method

.method public b()Laim;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/MapBaseFragment;->a:Laim;

    return-object v0
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 1

    .prologue
    .line 30
    invoke-super {p0, p1, p2, p3}, Lcom/google/android/gms/maps/SupportMapFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    move-result-object v0

    .line 31
    invoke-virtual {p0}, Lcom/bestbuy/android/bbyobjects/MapBaseFragment;->a()V

    .line 32
    return-object v0
.end method
