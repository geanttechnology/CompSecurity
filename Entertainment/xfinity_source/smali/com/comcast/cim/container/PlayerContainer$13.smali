.class Lcom/comcast/cim/container/PlayerContainer$13;
.super Ljava/lang/Object;
.source "PlayerContainer.java"

# interfaces
.implements Lcom/ijsbrandslob/appirater/Appirater$Configuration;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/container/PlayerContainer;->getAppiraterConfig()Lcom/ijsbrandslob/appirater/Appirater$Configuration;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/container/PlayerContainer;


# direct methods
.method constructor <init>(Lcom/comcast/cim/container/PlayerContainer;)V
    .locals 0
    .param p1, "this$0"    # Lcom/comcast/cim/container/PlayerContainer;

    .prologue
    .line 1362
    iput-object p1, p0, Lcom/comcast/cim/container/PlayerContainer$13;->this$0:Lcom/comcast/cim/container/PlayerContainer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getDaysUntilPrompt()I
    .locals 1

    .prologue
    .line 1365
    const/4 v0, 0x0

    return v0
.end method

.method public getMillisBeforeReminding()I
    .locals 1

    .prologue
    .line 1380
    const v0, 0xea60

    return v0
.end method

.method public getSignificantEventsUntilPrompt()I
    .locals 1

    .prologue
    .line 1375
    const/4 v0, 0x1

    return v0
.end method

.method public getUsesUntilPrompt()I
    .locals 1

    .prologue
    .line 1370
    const/4 v0, 0x0

    return v0
.end method
