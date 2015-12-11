.class Lcom/bestbuy/android/activities/home/HomeFragment$4;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/home/HomeFragment;->d()V
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/home/HomeFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/home/HomeFragment;)V
    .locals 0

    .prologue
    .line 334
    iput-object p1, p0, Lcom/bestbuy/android/activities/home/HomeFragment$4;->a:Lcom/bestbuy/android/activities/home/HomeFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 337
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    .line 338
    new-instance v1, Lcom/bestbuy/android/activities/home/HomeFragment$4$1;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/home/HomeFragment$4$1;-><init>(Lcom/bestbuy/android/activities/home/HomeFragment$4;)V

    const-wide/16 v2, 0xbb8

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 346
    return-void
.end method
