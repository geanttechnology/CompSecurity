.class public final Lcom/amazon/identity/auth/device/utils/AccountConstants$PublicUserData;
.super Ljava/lang/Object;
.source "AccountConstants.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/utils/AccountConstants;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "PublicUserData"
.end annotation


# static fields
.field public static final EXTRA_TOKENS_KEY_PREFIX:Ljava/lang/String; = "com.amazon.dcp.sso.property.account.extratokens"

.field public static final KEY_DEVICE_DEVICE_EMAIL:Ljava/lang/String; = "com.amazon.dcp.sso.property.deviceemail"

.field public static final KEY_DEVICE_DEVICE_NAME:Ljava/lang/String; = "com.amazon.dcp.sso.property.devicename"

.field public static final KEY_DEVICE_USER_NAME:Ljava/lang/String; = "com.amazon.dcp.sso.property.username"

.field public static final KEY_USER_EMAIL:Ljava/lang/String; = "com.amazon.dcp.sso.property.account.useremail"


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 132
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 133
    return-void
.end method
