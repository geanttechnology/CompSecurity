.class public Lhc;
.super Lka;
.source "SourceFile"


# instance fields
.field private a:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0, p1, p2}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    .line 15
    iput-object p3, p0, Lhc;->a:Ljava/lang/String;

    .line 16
    return-void
.end method


# virtual methods
.method public a()V
    .locals 2

    .prologue
    .line 24
    iget-object v0, p0, Lhc;->f:Landroid/app/Activity;

    iget-object v1, p0, Lhc;->a:Ljava/lang/String;

    invoke-static {v0, v1}, Lfs;->a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    .line 25
    return-void
.end method

.method public b()V
    .locals 0

    .prologue
    .line 29
    return-void
.end method

.method public c()V
    .locals 0

    .prologue
    .line 33
    return-void
.end method

.method public onPreExecute()V
    .locals 0

    .prologue
    .line 19
    invoke-super {p0}, Lka;->onPreExecute()V

    .line 20
    return-void
.end method
