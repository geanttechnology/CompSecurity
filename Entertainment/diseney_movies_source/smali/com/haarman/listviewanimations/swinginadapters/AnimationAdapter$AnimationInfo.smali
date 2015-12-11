.class Lcom/haarman/listviewanimations/swinginadapters/AnimationAdapter$AnimationInfo;
.super Ljava/lang/Object;
.source "AnimationAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/haarman/listviewanimations/swinginadapters/AnimationAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "AnimationInfo"
.end annotation


# instance fields
.field public animator:Lcom/nineoldandroids/animation/Animator;

.field public position:I

.field final synthetic this$0:Lcom/haarman/listviewanimations/swinginadapters/AnimationAdapter;


# direct methods
.method public constructor <init>(Lcom/haarman/listviewanimations/swinginadapters/AnimationAdapter;ILcom/nineoldandroids/animation/Animator;)V
    .locals 0
    .param p2, "position"    # I
    .param p3, "animator"    # Lcom/nineoldandroids/animation/Animator;

    .prologue
    .line 212
    iput-object p1, p0, Lcom/haarman/listviewanimations/swinginadapters/AnimationAdapter$AnimationInfo;->this$0:Lcom/haarman/listviewanimations/swinginadapters/AnimationAdapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 213
    iput p2, p0, Lcom/haarman/listviewanimations/swinginadapters/AnimationAdapter$AnimationInfo;->position:I

    .line 214
    iput-object p3, p0, Lcom/haarman/listviewanimations/swinginadapters/AnimationAdapter$AnimationInfo;->animator:Lcom/nineoldandroids/animation/Animator;

    .line 215
    return-void
.end method
