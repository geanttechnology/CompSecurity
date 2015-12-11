.class Lcom/amazon/mShop/feature/Features$2$1;
.super Ljava/lang/Object;
.source "Features.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/feature/Features$2;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/mShop/feature/Features$2;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/feature/Features$2;)V
    .locals 0

    .prologue
    .line 651
    iput-object p1, p0, Lcom/amazon/mShop/feature/Features$2$1;->this$1:Lcom/amazon/mShop/feature/Features$2;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 654
    iget-object v0, p0, Lcom/amazon/mShop/feature/Features$2$1;->this$1:Lcom/amazon/mShop/feature/Features$2;

    iget-object v0, v0, Lcom/amazon/mShop/feature/Features$2;->this$0:Lcom/amazon/mShop/feature/Features;

    # invokes: Lcom/amazon/mShop/feature/Features;->clearTimer()V
    invoke-static {v0}, Lcom/amazon/mShop/feature/Features;->access$500(Lcom/amazon/mShop/feature/Features;)V

    .line 655
    return-void
.end method
