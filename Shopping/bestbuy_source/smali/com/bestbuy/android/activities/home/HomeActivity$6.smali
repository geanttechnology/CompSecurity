.class Lcom/bestbuy/android/activities/home/HomeActivity$6;
.super Landroid/content/BroadcastReceiver;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/bestbuy/android/activities/home/HomeActivity;
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/home/HomeActivity;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/home/HomeActivity;)V
    .locals 0

    .prologue
    .line 840
    iput-object p1, p0, Lcom/bestbuy/android/activities/home/HomeActivity$6;->a:Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 1

    .prologue
    .line 843
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity$6;->a:Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->buildSideMenu()V

    .line 844
    return-void
.end method
