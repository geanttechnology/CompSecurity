.class Lcom/kochava/android/tracker/KochavaWebAdView$2;
.super Ljava/lang/Object;
.source "KochavaWebAdView.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/kochava/android/tracker/KochavaWebAdView;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/kochava/android/tracker/KochavaWebAdView;


# direct methods
.method constructor <init>(Lcom/kochava/android/tracker/KochavaWebAdView;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/kochava/android/tracker/KochavaWebAdView$2;->this$0:Lcom/kochava/android/tracker/KochavaWebAdView;

    .line 165
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 169
    iget-object v0, p0, Lcom/kochava/android/tracker/KochavaWebAdView$2;->this$0:Lcom/kochava/android/tracker/KochavaWebAdView;

    invoke-virtual {v0}, Lcom/kochava/android/tracker/KochavaWebAdView;->onBackPressed()V

    .line 170
    return-void
.end method
