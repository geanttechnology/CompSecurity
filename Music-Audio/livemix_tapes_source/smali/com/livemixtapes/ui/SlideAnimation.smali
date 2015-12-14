.class public Lcom/livemixtapes/ui/SlideAnimation;
.super Ljava/lang/Object;
.source "SlideAnimation.java"


# static fields
.field public static ANIMATION_FINISH_ENTER:I

.field public static ANIMATION_FINISH_LEAVE:I

.field public static ANIMATION_START_ENTER:I

.field public static ANIMATION_START_LEAVE:I

.field public static FRAGMENT_FINISH_ENTER:I

.field public static FRAGMENT_FINISH_LEAVE:I

.field public static FRAGMENT_START_ENTER:I

.field public static FRAGMENT_START_LEAVE:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 9
    const v0, 0x7f040008

    sput v0, Lcom/livemixtapes/ui/SlideAnimation;->ANIMATION_START_ENTER:I

    .line 10
    const v0, 0x7f040009

    sput v0, Lcom/livemixtapes/ui/SlideAnimation;->ANIMATION_START_LEAVE:I

    .line 11
    const v0, 0x7f040007

    sput v0, Lcom/livemixtapes/ui/SlideAnimation;->ANIMATION_FINISH_LEAVE:I

    .line 12
    const v0, 0x7f040006

    sput v0, Lcom/livemixtapes/ui/SlideAnimation;->ANIMATION_FINISH_ENTER:I

    .line 15
    const v0, 0x7f050002

    sput v0, Lcom/livemixtapes/ui/SlideAnimation;->FRAGMENT_START_ENTER:I

    .line 16
    const v0, 0x7f050003

    sput v0, Lcom/livemixtapes/ui/SlideAnimation;->FRAGMENT_START_LEAVE:I

    .line 17
    const v0, 0x7f050001

    sput v0, Lcom/livemixtapes/ui/SlideAnimation;->FRAGMENT_FINISH_LEAVE:I

    .line 18
    const/high16 v0, 0x7f050000

    sput v0, Lcom/livemixtapes/ui/SlideAnimation;->FRAGMENT_FINISH_ENTER:I

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 7
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static startCloseAnimation(Landroid/app/Activity;)V
    .locals 2
    .param p0, "act"    # Landroid/app/Activity;

    .prologue
    .line 24
    sget v0, Lcom/livemixtapes/ui/SlideAnimation;->ANIMATION_FINISH_LEAVE:I

    sget v1, Lcom/livemixtapes/ui/SlideAnimation;->ANIMATION_FINISH_ENTER:I

    invoke-virtual {p0, v0, v1}, Landroid/app/Activity;->overridePendingTransition(II)V

    .line 25
    return-void
.end method

.method public static startOpenAnimation(Landroid/app/Activity;)V
    .locals 2
    .param p0, "act"    # Landroid/app/Activity;

    .prologue
    .line 21
    sget v0, Lcom/livemixtapes/ui/SlideAnimation;->ANIMATION_START_ENTER:I

    sget v1, Lcom/livemixtapes/ui/SlideAnimation;->ANIMATION_START_LEAVE:I

    invoke-virtual {p0, v0, v1}, Landroid/app/Activity;->overridePendingTransition(II)V

    .line 22
    return-void
.end method
