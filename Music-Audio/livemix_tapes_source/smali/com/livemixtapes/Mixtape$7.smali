.class Lcom/livemixtapes/Mixtape$7;
.super Lcom/livemixtapes/App$OnLayoutMeasureListener;
.source "Mixtape.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/Mixtape;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/livemixtapes/Mixtape;


# direct methods
.method constructor <init>(Lcom/livemixtapes/Mixtape;Landroid/view/ViewGroup;)V
    .locals 0
    .param p2, "$anonymous0"    # Landroid/view/ViewGroup;

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/Mixtape$7;->this$0:Lcom/livemixtapes/Mixtape;

    .line 605
    invoke-direct {p0, p2}, Lcom/livemixtapes/App$OnLayoutMeasureListener;-><init>(Landroid/view/ViewGroup;)V

    return-void
.end method


# virtual methods
.method public onLayoutMeasure()V
    .locals 1

    .prologue
    .line 608
    iget-object v0, p0, Lcom/livemixtapes/Mixtape$7;->this$0:Lcom/livemixtapes/Mixtape;

    invoke-virtual {v0}, Lcom/livemixtapes/Mixtape;->calcMeasurements()V

    .line 609
    return-void
.end method
