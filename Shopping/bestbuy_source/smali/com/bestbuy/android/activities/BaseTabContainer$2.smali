.class Lcom/bestbuy/android/activities/BaseTabContainer$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/BaseTabContainer;->c()V
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/BaseTabContainer;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/BaseTabContainer;)V
    .locals 0

    .prologue
    .line 152
    iput-object p1, p0, Lcom/bestbuy/android/activities/BaseTabContainer$2;->a:Lcom/bestbuy/android/activities/BaseTabContainer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 156
    iget-object v0, p0, Lcom/bestbuy/android/activities/BaseTabContainer$2;->a:Lcom/bestbuy/android/activities/BaseTabContainer;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/BaseTabContainer;->a_()V

    .line 157
    return-void
.end method
