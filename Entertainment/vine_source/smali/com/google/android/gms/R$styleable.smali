.class public final Lcom/google/android/gms/R$styleable;
.super Ljava/lang/Object;
.source "R.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/gms/R;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "styleable"
.end annotation


# static fields
.field public static final AdsAttrs:[I

.field public static final AdsAttrs_adSize:I = 0x0

.field public static final AdsAttrs_adSizes:I = 0x1

.field public static final AdsAttrs_adUnitId:I = 0x2

.field public static final MapAttrs:[I

.field public static final MapAttrs_cameraBearing:I = 0x1

.field public static final MapAttrs_cameraTargetLat:I = 0x2

.field public static final MapAttrs_cameraTargetLng:I = 0x3

.field public static final MapAttrs_cameraTilt:I = 0x4

.field public static final MapAttrs_cameraZoom:I = 0x5

.field public static final MapAttrs_mapType:I = 0x0

.field public static final MapAttrs_uiCompass:I = 0x6

.field public static final MapAttrs_uiRotateGestures:I = 0x7

.field public static final MapAttrs_uiScrollGestures:I = 0x8

.field public static final MapAttrs_uiTiltGestures:I = 0x9

.field public static final MapAttrs_uiZoomControls:I = 0xa

.field public static final MapAttrs_uiZoomGestures:I = 0xb

.field public static final MapAttrs_useViewLifecycle:I = 0xc

.field public static final MapAttrs_zOrderOnTop:I = 0xd

.field public static final WalletFragmentOptions:[I

.field public static final WalletFragmentOptions_environment:I = 0x1

.field public static final WalletFragmentOptions_fragmentMode:I = 0x3

.field public static final WalletFragmentOptions_fragmentStyle:I = 0x2

.field public static final WalletFragmentOptions_theme:I = 0x0

.field public static final WalletFragmentStyle:[I

.field public static final WalletFragmentStyle_buyButtonAppearance:I = 0x3

.field public static final WalletFragmentStyle_buyButtonHeight:I = 0x0

.field public static final WalletFragmentStyle_buyButtonText:I = 0x2

.field public static final WalletFragmentStyle_buyButtonWidth:I = 0x1

.field public static final WalletFragmentStyle_maskedWalletDetailsBackground:I = 0x6

.field public static final WalletFragmentStyle_maskedWalletDetailsButtonBackground:I = 0x8

.field public static final WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance:I = 0x7

.field public static final WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance:I = 0x5

.field public static final WalletFragmentStyle_maskedWalletDetailsLogoImageType:I = 0xa

.field public static final WalletFragmentStyle_maskedWalletDetailsLogoTextColor:I = 0x9

.field public static final WalletFragmentStyle_maskedWalletDetailsTextAppearance:I = 0x4


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 169
    const/4 v0, 0x3

    new-array v0, v0, [I

    fill-array-data v0, :array_0

    sput-object v0, Lcom/google/android/gms/R$styleable;->AdsAttrs:[I

    .line 173
    const/16 v0, 0xe

    new-array v0, v0, [I

    fill-array-data v0, :array_1

    sput-object v0, Lcom/google/android/gms/R$styleable;->MapAttrs:[I

    .line 188
    const/4 v0, 0x4

    new-array v0, v0, [I

    fill-array-data v0, :array_2

    sput-object v0, Lcom/google/android/gms/R$styleable;->WalletFragmentOptions:[I

    .line 193
    const/16 v0, 0xb

    new-array v0, v0, [I

    fill-array-data v0, :array_3

    sput-object v0, Lcom/google/android/gms/R$styleable;->WalletFragmentStyle:[I

    return-void

    .line 169
    nop

    :array_0
    .array-data 4
        0x7f010062
        0x7f010063
        0x7f010064
    .end array-data

    .line 173
    :array_1
    .array-data 4
        0x7f01008b
        0x7f01008c
        0x7f01008d
        0x7f01008e
        0x7f01008f
        0x7f010090
        0x7f010091
        0x7f010092
        0x7f010093
        0x7f010094
        0x7f010095
        0x7f010096
        0x7f010097
        0x7f010098
    .end array-data

    .line 188
    :array_2
    .array-data 4
        0x7f0100d0
        0x7f0100d1
        0x7f0100d2
        0x7f0100d3
    .end array-data

    .line 193
    :array_3
    .array-data 4
        0x7f0100d4
        0x7f0100d5
        0x7f0100d6
        0x7f0100d7
        0x7f0100d8
        0x7f0100d9
        0x7f0100da
        0x7f0100db
        0x7f0100dc
        0x7f0100dd
        0x7f0100de
    .end array-data
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 168
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
