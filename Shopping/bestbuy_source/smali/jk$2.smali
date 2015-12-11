.class Ljk$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lnn;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ljk;->c()V
.end annotation


# instance fields
.field final synthetic a:Ljk;


# direct methods
.method constructor <init>(Ljk;)V
    .locals 0

    .prologue
    .line 74
    iput-object p1, p0, Ljk$2;->a:Ljk;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 77
    const/4 v0, 0x0

    invoke-static {v0}, Ljk;->a(I)I

    .line 78
    iget-object v0, p0, Ljk$2;->a:Ljk;

    invoke-static {v0}, Ljk;->a(Ljk;)Landroid/app/Activity;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->onBackPressed()V

    .line 79
    return-void
.end method
