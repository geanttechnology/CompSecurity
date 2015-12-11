.class Lcom/comcast/cim/container/CALContainer$2;
.super Ljava/lang/Object;
.source "CALContainer.java"

# interfaces
.implements Landroid/view/LayoutInflater$Factory;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/container/CALContainer;->getLayoutInflatorFactory()Landroid/view/LayoutInflater$Factory;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/container/CALContainer;


# direct methods
.method constructor <init>(Lcom/comcast/cim/container/CALContainer;)V
    .locals 0
    .param p1, "this$0"    # Lcom/comcast/cim/container/CALContainer;

    .prologue
    .line 381
    iput-object p1, p0, Lcom/comcast/cim/container/CALContainer$2;->this$0:Lcom/comcast/cim/container/CALContainer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCreateView(Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "context"    # Landroid/content/Context;
    .param p3, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 384
    const/4 v0, 0x0

    return-object v0
.end method
