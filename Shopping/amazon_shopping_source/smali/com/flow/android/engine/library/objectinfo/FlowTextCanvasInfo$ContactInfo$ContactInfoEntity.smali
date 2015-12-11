.class public Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoEntity;
.super Ljava/lang/Object;
.source "FlowTextCanvasInfo.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "ContactInfoEntity"
.end annotation


# instance fields
.field public content:Ljava/lang/String;

.field public isVerified:Z

.field final synthetic this$0:Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;

.field public type:Ljava/lang/String;


# direct methods
.method public constructor <init>(Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;)V
    .locals 1

    .prologue
    .line 328
    iput-object p1, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoEntity;->this$0:Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 324
    const-string/jumbo v0, ""

    iput-object v0, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoEntity;->type:Ljava/lang/String;

    .line 325
    const-string/jumbo v0, ""

    iput-object v0, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoEntity;->content:Ljava/lang/String;

    .line 326
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoEntity;->isVerified:Z

    .line 328
    return-void
.end method

.method public constructor <init>(Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;Ljava/lang/String;)V
    .locals 1
    .param p2, "a_content"    # Ljava/lang/String;

    .prologue
    .line 330
    iput-object p1, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoEntity;->this$0:Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 324
    const-string/jumbo v0, ""

    iput-object v0, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoEntity;->type:Ljava/lang/String;

    .line 325
    const-string/jumbo v0, ""

    iput-object v0, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoEntity;->content:Ljava/lang/String;

    .line 326
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoEntity;->isVerified:Z

    .line 331
    iput-object p2, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoEntity;->content:Ljava/lang/String;

    .line 332
    return-void
.end method

.method public constructor <init>(Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p2, "a_type"    # Ljava/lang/String;
    .param p3, "a_content"    # Ljava/lang/String;

    .prologue
    .line 334
    iput-object p1, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoEntity;->this$0:Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 324
    const-string/jumbo v0, ""

    iput-object v0, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoEntity;->type:Ljava/lang/String;

    .line 325
    const-string/jumbo v0, ""

    iput-object v0, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoEntity;->content:Ljava/lang/String;

    .line 326
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoEntity;->isVerified:Z

    .line 335
    iput-object p2, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoEntity;->type:Ljava/lang/String;

    .line 336
    iput-object p3, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoEntity;->content:Ljava/lang/String;

    .line 337
    return-void
.end method
