.class Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$2;
.super Ljava/lang/Object;
.source "SeriesEntityActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;

    .prologue
    .line 121
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$2;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 124
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$2;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;

    # invokes: Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->triggerLoading()V
    invoke-static {v0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->access$400(Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;)V

    .line 125
    return-void
.end method
