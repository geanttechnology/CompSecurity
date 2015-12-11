.class final enum Lcom/amazon/mShop/aiv/AivHttpIntentActivity$Command$3;
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


# static fields
.field private static final RESUME_POINT_POSITION:I = 0x5


# direct methods
.method constructor <init>(Ljava/lang/String;ILjava/lang/String;I)V
    .locals 6
    .param p3, "x0"    # Ljava/lang/String;
    .param p4, "x1"    # I

    .prologue
    .line 41
    const/4 v5, 0x0

    move-object v0, p0

    move-object v1, p1

    move v2, p2

    move-object v3, p3

    move v4, p4

    invoke-direct/range {v0 .. v5}, Lcom/amazon/mShop/aiv/AivHttpIntentActivity$Command;-><init>(Ljava/lang/String;ILjava/lang/String;ILcom/amazon/mShop/aiv/AivHttpIntentActivity$1;)V

    return-void
.end method


# virtual methods
.method public performCommand(Landroid/app/Activity;Ljava/util/List;)V
    .locals 5
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
    .line 44
    .local p2, "segments":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const/4 v1, 0x5

    invoke-interface {p2, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 45
    .local v0, "resumePoint":Ljava/lang/String;
    # getter for: Lcom/amazon/mShop/aiv/AivHttpIntentActivity;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/aiv/AivHttpIntentActivity;->access$100()Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v2, "Operation %s not currently supported"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p0, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 46
    return-void
.end method
