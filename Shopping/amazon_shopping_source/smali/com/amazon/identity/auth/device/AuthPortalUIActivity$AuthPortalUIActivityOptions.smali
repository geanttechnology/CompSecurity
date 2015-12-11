.class public final Lcom/amazon/identity/auth/device/AuthPortalUIActivity$AuthPortalUIActivityOptions;
.super Ljava/lang/Object;
.source "AuthPortalUIActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/AuthPortalUIActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "AuthPortalUIActivityOptions"
.end annotation


# static fields
.field public static final KEY_DIRECTEDID:Ljava/lang/String; = "directedid"

.field public static final KEY_REQUEST_TYPE:Ljava/lang/String; = "requestType"

.field public static final KEY_SESSIONID:Ljava/lang/String; = "com.amazon.identity.sessionid"

.field public static final KEY_UBID:Ljava/lang/String; = "com.amazon.identity.ubid"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 88
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
