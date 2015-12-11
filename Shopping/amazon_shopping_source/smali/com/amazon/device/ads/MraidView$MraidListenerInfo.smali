.class Lcom/amazon/device/ads/MraidView$MraidListenerInfo;
.super Ljava/lang/Object;
.source "MraidView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/device/ads/MraidView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "MraidListenerInfo"
.end annotation


# instance fields
.field private mOnCloseButtonListener:Lcom/amazon/device/ads/MraidView$OnCloseButtonStateChangeListener;

.field private mOnCloseListener:Lcom/amazon/device/ads/MraidView$OnCloseListener;

.field private mOnExpandListener:Lcom/amazon/device/ads/MraidView$OnExpandListener;

.field private mOnFailureListener:Lcom/amazon/device/ads/MraidView$OnFailureListener;

.field private mOnOpenListener:Lcom/amazon/device/ads/MraidView$OnOpenListener;

.field private mOnReadyListener:Lcom/amazon/device/ads/MraidView$OnReadyListener;

.field private mOnSpecialUrlClickListener:Lcom/amazon/device/ads/MraidView$OnSpecialUrlClickListener;


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 53
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$000(Lcom/amazon/device/ads/MraidView$MraidListenerInfo;)Lcom/amazon/device/ads/MraidView$OnFailureListener;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/device/ads/MraidView$MraidListenerInfo;

    .prologue
    .line 53
    iget-object v0, p0, Lcom/amazon/device/ads/MraidView$MraidListenerInfo;->mOnFailureListener:Lcom/amazon/device/ads/MraidView$OnFailureListener;

    return-object v0
.end method

.method static synthetic access$002(Lcom/amazon/device/ads/MraidView$MraidListenerInfo;Lcom/amazon/device/ads/MraidView$OnFailureListener;)Lcom/amazon/device/ads/MraidView$OnFailureListener;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/device/ads/MraidView$MraidListenerInfo;
    .param p1, "x1"    # Lcom/amazon/device/ads/MraidView$OnFailureListener;

    .prologue
    .line 53
    iput-object p1, p0, Lcom/amazon/device/ads/MraidView$MraidListenerInfo;->mOnFailureListener:Lcom/amazon/device/ads/MraidView$OnFailureListener;

    return-object p1
.end method

.method static synthetic access$100(Lcom/amazon/device/ads/MraidView$MraidListenerInfo;)Lcom/amazon/device/ads/MraidView$OnExpandListener;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/device/ads/MraidView$MraidListenerInfo;

    .prologue
    .line 53
    iget-object v0, p0, Lcom/amazon/device/ads/MraidView$MraidListenerInfo;->mOnExpandListener:Lcom/amazon/device/ads/MraidView$OnExpandListener;

    return-object v0
.end method

.method static synthetic access$102(Lcom/amazon/device/ads/MraidView$MraidListenerInfo;Lcom/amazon/device/ads/MraidView$OnExpandListener;)Lcom/amazon/device/ads/MraidView$OnExpandListener;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/device/ads/MraidView$MraidListenerInfo;
    .param p1, "x1"    # Lcom/amazon/device/ads/MraidView$OnExpandListener;

    .prologue
    .line 53
    iput-object p1, p0, Lcom/amazon/device/ads/MraidView$MraidListenerInfo;->mOnExpandListener:Lcom/amazon/device/ads/MraidView$OnExpandListener;

    return-object p1
.end method

.method static synthetic access$200(Lcom/amazon/device/ads/MraidView$MraidListenerInfo;)Lcom/amazon/device/ads/MraidView$OnCloseListener;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/device/ads/MraidView$MraidListenerInfo;

    .prologue
    .line 53
    iget-object v0, p0, Lcom/amazon/device/ads/MraidView$MraidListenerInfo;->mOnCloseListener:Lcom/amazon/device/ads/MraidView$OnCloseListener;

    return-object v0
.end method

.method static synthetic access$202(Lcom/amazon/device/ads/MraidView$MraidListenerInfo;Lcom/amazon/device/ads/MraidView$OnCloseListener;)Lcom/amazon/device/ads/MraidView$OnCloseListener;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/device/ads/MraidView$MraidListenerInfo;
    .param p1, "x1"    # Lcom/amazon/device/ads/MraidView$OnCloseListener;

    .prologue
    .line 53
    iput-object p1, p0, Lcom/amazon/device/ads/MraidView$MraidListenerInfo;->mOnCloseListener:Lcom/amazon/device/ads/MraidView$OnCloseListener;

    return-object p1
.end method

.method static synthetic access$300(Lcom/amazon/device/ads/MraidView$MraidListenerInfo;)Lcom/amazon/device/ads/MraidView$OnReadyListener;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/device/ads/MraidView$MraidListenerInfo;

    .prologue
    .line 53
    iget-object v0, p0, Lcom/amazon/device/ads/MraidView$MraidListenerInfo;->mOnReadyListener:Lcom/amazon/device/ads/MraidView$OnReadyListener;

    return-object v0
.end method

.method static synthetic access$302(Lcom/amazon/device/ads/MraidView$MraidListenerInfo;Lcom/amazon/device/ads/MraidView$OnReadyListener;)Lcom/amazon/device/ads/MraidView$OnReadyListener;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/device/ads/MraidView$MraidListenerInfo;
    .param p1, "x1"    # Lcom/amazon/device/ads/MraidView$OnReadyListener;

    .prologue
    .line 53
    iput-object p1, p0, Lcom/amazon/device/ads/MraidView$MraidListenerInfo;->mOnReadyListener:Lcom/amazon/device/ads/MraidView$OnReadyListener;

    return-object p1
.end method

.method static synthetic access$400(Lcom/amazon/device/ads/MraidView$MraidListenerInfo;)Lcom/amazon/device/ads/MraidView$OnCloseButtonStateChangeListener;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/device/ads/MraidView$MraidListenerInfo;

    .prologue
    .line 53
    iget-object v0, p0, Lcom/amazon/device/ads/MraidView$MraidListenerInfo;->mOnCloseButtonListener:Lcom/amazon/device/ads/MraidView$OnCloseButtonStateChangeListener;

    return-object v0
.end method

.method static synthetic access$402(Lcom/amazon/device/ads/MraidView$MraidListenerInfo;Lcom/amazon/device/ads/MraidView$OnCloseButtonStateChangeListener;)Lcom/amazon/device/ads/MraidView$OnCloseButtonStateChangeListener;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/device/ads/MraidView$MraidListenerInfo;
    .param p1, "x1"    # Lcom/amazon/device/ads/MraidView$OnCloseButtonStateChangeListener;

    .prologue
    .line 53
    iput-object p1, p0, Lcom/amazon/device/ads/MraidView$MraidListenerInfo;->mOnCloseButtonListener:Lcom/amazon/device/ads/MraidView$OnCloseButtonStateChangeListener;

    return-object p1
.end method

.method static synthetic access$500(Lcom/amazon/device/ads/MraidView$MraidListenerInfo;)Lcom/amazon/device/ads/MraidView$OnOpenListener;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/device/ads/MraidView$MraidListenerInfo;

    .prologue
    .line 53
    iget-object v0, p0, Lcom/amazon/device/ads/MraidView$MraidListenerInfo;->mOnOpenListener:Lcom/amazon/device/ads/MraidView$OnOpenListener;

    return-object v0
.end method

.method static synthetic access$502(Lcom/amazon/device/ads/MraidView$MraidListenerInfo;Lcom/amazon/device/ads/MraidView$OnOpenListener;)Lcom/amazon/device/ads/MraidView$OnOpenListener;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/device/ads/MraidView$MraidListenerInfo;
    .param p1, "x1"    # Lcom/amazon/device/ads/MraidView$OnOpenListener;

    .prologue
    .line 53
    iput-object p1, p0, Lcom/amazon/device/ads/MraidView$MraidListenerInfo;->mOnOpenListener:Lcom/amazon/device/ads/MraidView$OnOpenListener;

    return-object p1
.end method

.method static synthetic access$600(Lcom/amazon/device/ads/MraidView$MraidListenerInfo;)Lcom/amazon/device/ads/MraidView$OnSpecialUrlClickListener;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/device/ads/MraidView$MraidListenerInfo;

    .prologue
    .line 53
    iget-object v0, p0, Lcom/amazon/device/ads/MraidView$MraidListenerInfo;->mOnSpecialUrlClickListener:Lcom/amazon/device/ads/MraidView$OnSpecialUrlClickListener;

    return-object v0
.end method

.method static synthetic access$602(Lcom/amazon/device/ads/MraidView$MraidListenerInfo;Lcom/amazon/device/ads/MraidView$OnSpecialUrlClickListener;)Lcom/amazon/device/ads/MraidView$OnSpecialUrlClickListener;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/device/ads/MraidView$MraidListenerInfo;
    .param p1, "x1"    # Lcom/amazon/device/ads/MraidView$OnSpecialUrlClickListener;

    .prologue
    .line 53
    iput-object p1, p0, Lcom/amazon/device/ads/MraidView$MraidListenerInfo;->mOnSpecialUrlClickListener:Lcom/amazon/device/ads/MraidView$OnSpecialUrlClickListener;

    return-object p1
.end method
