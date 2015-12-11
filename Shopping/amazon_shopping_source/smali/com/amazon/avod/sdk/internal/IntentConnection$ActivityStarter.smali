.class Lcom/amazon/avod/sdk/internal/IntentConnection$ActivityStarter;
.super Ljava/lang/Object;
.source "IntentConnection.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/avod/sdk/internal/IntentConnection;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "ActivityStarter"
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 371
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/avod/sdk/internal/IntentConnection$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/avod/sdk/internal/IntentConnection$1;

    .prologue
    .line 371
    invoke-direct {p0}, Lcom/amazon/avod/sdk/internal/IntentConnection$ActivityStarter;-><init>()V

    return-void
.end method


# virtual methods
.method public startActivity(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 375
    instance-of v0, p1, Landroid/app/Activity;

    if-eqz v0, :cond_0

    .line 377
    const/high16 v0, 0x24000000

    invoke-virtual {p2, v0}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 378
    const-string/jumbo v0, "android.intent.action.VIEW"

    invoke-virtual {p2, v0}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 379
    check-cast p1, Landroid/app/Activity;

    .end local p1    # "context":Landroid/content/Context;
    const/4 v0, 0x0

    invoke-virtual {p1, p2, v0}, Landroid/app/Activity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 386
    :goto_0
    return-void

    .line 381
    .restart local p1    # "context":Landroid/content/Context;
    :cond_0
    const/high16 v0, 0x34000000

    invoke-virtual {p2, v0}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 384
    invoke-virtual {p1, p2}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    goto :goto_0
.end method
