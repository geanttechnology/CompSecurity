.class public Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoAddress;
.super Ljava/lang/Object;
.source "FlowTextCanvasInfo.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "ContactInfoAddress"
.end annotation


# instance fields
.field public addrCity:Ljava/lang/String;

.field public addrState:Ljava/lang/String;

.field public addrStreet:Ljava/lang/String;

.field public addrZipCode:Ljava/lang/String;

.field public isVerified:Z

.field final synthetic this$0:Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;


# direct methods
.method public constructor <init>(Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;)V
    .locals 1

    .prologue
    .line 312
    iput-object p1, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoAddress;->this$0:Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 306
    const-string/jumbo v0, ""

    iput-object v0, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoAddress;->addrStreet:Ljava/lang/String;

    .line 307
    const-string/jumbo v0, ""

    iput-object v0, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoAddress;->addrCity:Ljava/lang/String;

    .line 308
    const-string/jumbo v0, ""

    iput-object v0, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoAddress;->addrState:Ljava/lang/String;

    .line 309
    const-string/jumbo v0, ""

    iput-object v0, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoAddress;->addrZipCode:Ljava/lang/String;

    .line 310
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoAddress;->isVerified:Z

    .line 312
    return-void
.end method
