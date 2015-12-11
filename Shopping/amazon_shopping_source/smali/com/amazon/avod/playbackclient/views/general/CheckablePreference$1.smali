.class Lcom/amazon/avod/playbackclient/views/general/CheckablePreference$1;
.super Ljava/lang/Object;
.source "CheckablePreference.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/avod/playbackclient/views/general/CheckablePreference;->onFinishInflate()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/avod/playbackclient/views/general/CheckablePreference;


# direct methods
.method constructor <init>(Lcom/amazon/avod/playbackclient/views/general/CheckablePreference;)V
    .locals 0

    .prologue
    .line 41
    iput-object p1, p0, Lcom/amazon/avod/playbackclient/views/general/CheckablePreference$1;->this$0:Lcom/amazon/avod/playbackclient/views/general/CheckablePreference;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;
    .annotation build Lcom/amazon/avod/clickstream/annotate/SuppressClickstreamReason;
        value = "We emit the refmarker when the view is toggled"
    .end annotation

    .prologue
    .line 45
    iget-object v0, p0, Lcom/amazon/avod/playbackclient/views/general/CheckablePreference$1;->this$0:Lcom/amazon/avod/playbackclient/views/general/CheckablePreference;

    # getter for: Lcom/amazon/avod/playbackclient/views/general/CheckablePreference;->mCheckableView:Landroid/widget/Checkable;
    invoke-static {v0}, Lcom/amazon/avod/playbackclient/views/general/CheckablePreference;->access$000(Lcom/amazon/avod/playbackclient/views/general/CheckablePreference;)Landroid/widget/Checkable;

    move-result-object v0

    invoke-interface {v0}, Landroid/widget/Checkable;->toggle()V

    .line 46
    return-void
.end method
