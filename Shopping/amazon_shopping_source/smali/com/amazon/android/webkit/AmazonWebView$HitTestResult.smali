.class public Lcom/amazon/android/webkit/AmazonWebView$HitTestResult;
.super Ljava/lang/Object;
.source "AmazonWebView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/android/webkit/AmazonWebView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "HitTestResult"
.end annotation


# instance fields
.field private final extra:Ljava/lang/String;

.field private final type:I


# direct methods
.method public constructor <init>(ILjava/lang/String;)V
    .locals 0
    .param p1, "type"    # I
    .param p2, "extra"    # Ljava/lang/String;

    .prologue
    .line 114
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 115
    iput p1, p0, Lcom/amazon/android/webkit/AmazonWebView$HitTestResult;->type:I

    .line 116
    iput-object p2, p0, Lcom/amazon/android/webkit/AmazonWebView$HitTestResult;->extra:Ljava/lang/String;

    .line 117
    return-void
.end method
