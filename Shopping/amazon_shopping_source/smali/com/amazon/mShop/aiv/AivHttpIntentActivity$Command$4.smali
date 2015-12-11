.class final enum Lcom/amazon/mShop/aiv/AivHttpIntentActivity$Command$4;
.super Lcom/amazon/mShop/aiv/AivHttpIntentActivity$Command;
.source "AivHttpIntentActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/aiv/AivHttpIntentActivity$Command;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4008
    name = null
.end annotation


# direct methods
.method constructor <init>(Ljava/lang/String;ILjava/lang/String;)V
    .locals 1
    .param p3, "x0"    # Ljava/lang/String;

    .prologue
    .line 48
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, p3, v0}, Lcom/amazon/mShop/aiv/AivHttpIntentActivity$Command;-><init>(Ljava/lang/String;ILjava/lang/String;Lcom/amazon/mShop/aiv/AivHttpIntentActivity$1;)V

    return-void
.end method


# virtual methods
.method public performCommand(Landroid/app/Activity;Ljava/util/List;)V
    .locals 4
    .param p1, "activity"    # Landroid/app/Activity;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/Activity;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 50
    .local p2, "segments":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    # getter for: Lcom/amazon/mShop/aiv/AivHttpIntentActivity;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/aiv/AivHttpIntentActivity;->access$100()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "Operation %s not currently supported"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object p0, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 51
    return-void
.end method
