.class public final Lcom/amazon/identity/auth/device/utils/AccountConstants$AmazonAccountInformation;
.super Ljava/lang/Object;
.source "AccountConstants.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/utils/AccountConstants;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "AmazonAccountInformation"
.end annotation


# static fields
.field public static final AMAZON_ACCOUNT_TYPE:Ljava/lang/String; = "com.amazon.account"

.field public static final ANONYMOUS_ACCOUNT:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 465
    const/4 v0, 0x0

    sput-object v0, Lcom/amazon/identity/auth/device/utils/AccountConstants$AmazonAccountInformation;->ANONYMOUS_ACCOUNT:Ljava/lang/String;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 468
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 469
    return-void
.end method
