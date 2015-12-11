.class Lhz$3;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lnn;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lhz;->h()V
.end annotation


# instance fields
.field final synthetic a:Lhz;


# direct methods
.method constructor <init>(Lhz;)V
    .locals 0

    .prologue
    .line 260
    iput-object p1, p0, Lhz$3;->a:Lhz;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 262
    const/4 v0, 0x0

    invoke-static {v0}, Lhz;->a(I)I

    .line 263
    iget-object v0, p0, Lhz$3;->a:Lhz;

    invoke-static {v0}, Lhz;->j(Lhz;)Landroid/app/Activity;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->onBackPressed()V

    .line 264
    return-void
.end method
