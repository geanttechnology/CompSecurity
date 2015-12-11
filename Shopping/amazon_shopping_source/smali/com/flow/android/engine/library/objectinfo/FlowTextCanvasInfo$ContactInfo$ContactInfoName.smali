.class public Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoName;
.super Ljava/lang/Object;
.source "FlowTextCanvasInfo.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "ContactInfoName"
.end annotation


# instance fields
.field public firstname:Ljava/lang/String;

.field public isVerified:Z

.field public lastname:Ljava/lang/String;

.field public middlename:Ljava/lang/String;

.field final synthetic this$0:Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;


# direct methods
.method public constructor <init>(Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;)V
    .locals 1

    .prologue
    .line 298
    iput-object p1, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoName;->this$0:Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 299
    const-string/jumbo v0, ""

    iput-object v0, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoName;->firstname:Ljava/lang/String;

    .line 300
    const-string/jumbo v0, ""

    iput-object v0, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoName;->middlename:Ljava/lang/String;

    .line 301
    const-string/jumbo v0, ""

    iput-object v0, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoName;->lastname:Ljava/lang/String;

    .line 302
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoName;->isVerified:Z

    return-void
.end method
