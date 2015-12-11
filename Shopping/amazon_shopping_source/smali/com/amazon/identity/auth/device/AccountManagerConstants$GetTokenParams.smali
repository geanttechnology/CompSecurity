.class public final Lcom/amazon/identity/auth/device/AccountManagerConstants$GetTokenParams;
.super Lcom/amazon/identity/auth/device/AccountManagerConstants$GetParams;
.source "AccountManagerConstants.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/AccountManagerConstants;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "GetTokenParams"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/device/AccountManagerConstants$GetTokenParams$TOKEN_TYPE;
    }
.end annotation


# static fields
.field public static final OPTION_TOKEN_TYPE:Ljava/lang/String; = "tokentype"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 126
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/AccountManagerConstants$GetParams;-><init>()V

    .line 130
    return-void
.end method
