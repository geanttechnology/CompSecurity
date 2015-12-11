.class public final Lcom/penthera/virtuososdk/utility/CommonUtil$Config;
.super Ljava/lang/Object;
.source "CommonUtil.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/penthera/virtuososdk/utility/CommonUtil;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Config"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/penthera/virtuososdk/utility/CommonUtil$Config$BUILD_TYPE;,
        Lcom/penthera/virtuososdk/utility/CommonUtil$Config$BuildFeatures;
    }
.end annotation


# static fields
.field public static final BUILD:Lcom/penthera/virtuososdk/utility/CommonUtil$Config$BUILD_TYPE;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 37
    sget-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$Config$BUILD_TYPE;->EGold:Lcom/penthera/virtuososdk/utility/CommonUtil$Config$BUILD_TYPE;

    sput-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$Config;->BUILD:Lcom/penthera/virtuososdk/utility/CommonUtil$Config$BUILD_TYPE;

    .line 32
    return-void
.end method
