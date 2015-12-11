.class Lcom/amazon/mShop/debug/DebugSettingsView$3;
.super Ljava/lang/Object;
.source "DebugSettingsView.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/debug/DebugSettingsView;-><init>(Lcom/amazon/mShop/debug/DebugSettingsActivity;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/debug/DebugSettingsView;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/debug/DebugSettingsView;)V
    .locals 0

    .prologue
    .line 111
    iput-object p1, p0, Lcom/amazon/mShop/debug/DebugSettingsView$3;->this$0:Lcom/amazon/mShop/debug/DebugSettingsView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 115
    new-instance v0, Ljava/lang/NullPointerException;

    invoke-direct {v0}, Ljava/lang/NullPointerException;-><init>()V

    throw v0
.end method
