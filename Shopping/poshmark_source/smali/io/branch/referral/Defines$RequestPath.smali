.class public final enum Lio/branch/referral/Defines$RequestPath;
.super Ljava/lang/Enum;
.source "Defines.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/branch/referral/Defines;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "RequestPath"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lio/branch/referral/Defines$RequestPath;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lio/branch/referral/Defines$RequestPath;

.field public static final enum ApplyReferralCode:Lio/branch/referral/Defines$RequestPath;

.field public static final enum CompletedAction:Lio/branch/referral/Defines$RequestPath;

.field public static final enum DebugConnect:Lio/branch/referral/Defines$RequestPath;

.field public static final enum GetCreditHistory:Lio/branch/referral/Defines$RequestPath;

.field public static final enum GetCredits:Lio/branch/referral/Defines$RequestPath;

.field public static final enum GetReferralCode:Lio/branch/referral/Defines$RequestPath;

.field public static final enum GetURL:Lio/branch/referral/Defines$RequestPath;

.field public static final enum IdentifyUser:Lio/branch/referral/Defines$RequestPath;

.field public static final enum Logout:Lio/branch/referral/Defines$RequestPath;

.field public static final enum RedeemRewards:Lio/branch/referral/Defines$RequestPath;

.field public static final enum Referrals:Lio/branch/referral/Defines$RequestPath;

.field public static final enum RegisterClose:Lio/branch/referral/Defines$RequestPath;

.field public static final enum RegisterInstall:Lio/branch/referral/Defines$RequestPath;

.field public static final enum RegisterOpen:Lio/branch/referral/Defines$RequestPath;

.field public static final enum RegisterView:Lio/branch/referral/Defines$RequestPath;

.field public static final enum SendAPPList:Lio/branch/referral/Defines$RequestPath;

.field public static final enum ValidateReferralCode:Lio/branch/referral/Defines$RequestPath;


# instance fields
.field private key:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 9

    .prologue
    const/4 v8, 0x4

    const/4 v7, 0x3

    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 106
    new-instance v0, Lio/branch/referral/Defines$RequestPath;

    const-string v1, "RedeemRewards"

    const-string v2, "v1/redeem"

    invoke-direct {v0, v1, v4, v2}, Lio/branch/referral/Defines$RequestPath;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lio/branch/referral/Defines$RequestPath;->RedeemRewards:Lio/branch/referral/Defines$RequestPath;

    .line 107
    new-instance v0, Lio/branch/referral/Defines$RequestPath;

    const-string v1, "GetURL"

    const-string v2, "v1/url"

    invoke-direct {v0, v1, v5, v2}, Lio/branch/referral/Defines$RequestPath;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lio/branch/referral/Defines$RequestPath;->GetURL:Lio/branch/referral/Defines$RequestPath;

    .line 108
    new-instance v0, Lio/branch/referral/Defines$RequestPath;

    const-string v1, "RegisterInstall"

    const-string v2, "v1/install"

    invoke-direct {v0, v1, v6, v2}, Lio/branch/referral/Defines$RequestPath;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lio/branch/referral/Defines$RequestPath;->RegisterInstall:Lio/branch/referral/Defines$RequestPath;

    .line 109
    new-instance v0, Lio/branch/referral/Defines$RequestPath;

    const-string v1, "RegisterClose"

    const-string v2, "v1/close"

    invoke-direct {v0, v1, v7, v2}, Lio/branch/referral/Defines$RequestPath;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lio/branch/referral/Defines$RequestPath;->RegisterClose:Lio/branch/referral/Defines$RequestPath;

    .line 110
    new-instance v0, Lio/branch/referral/Defines$RequestPath;

    const-string v1, "RegisterOpen"

    const-string v2, "v1/open"

    invoke-direct {v0, v1, v8, v2}, Lio/branch/referral/Defines$RequestPath;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lio/branch/referral/Defines$RequestPath;->RegisterOpen:Lio/branch/referral/Defines$RequestPath;

    .line 111
    new-instance v0, Lio/branch/referral/Defines$RequestPath;

    const-string v1, "RegisterView"

    const/4 v2, 0x5

    const-string v3, "v1/register-view"

    invoke-direct {v0, v1, v2, v3}, Lio/branch/referral/Defines$RequestPath;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lio/branch/referral/Defines$RequestPath;->RegisterView:Lio/branch/referral/Defines$RequestPath;

    .line 112
    new-instance v0, Lio/branch/referral/Defines$RequestPath;

    const-string v1, "Referrals"

    const/4 v2, 0x6

    const-string v3, "v1/referrals/"

    invoke-direct {v0, v1, v2, v3}, Lio/branch/referral/Defines$RequestPath;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lio/branch/referral/Defines$RequestPath;->Referrals:Lio/branch/referral/Defines$RequestPath;

    .line 113
    new-instance v0, Lio/branch/referral/Defines$RequestPath;

    const-string v1, "SendAPPList"

    const/4 v2, 0x7

    const-string v3, "v1/applist"

    invoke-direct {v0, v1, v2, v3}, Lio/branch/referral/Defines$RequestPath;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lio/branch/referral/Defines$RequestPath;->SendAPPList:Lio/branch/referral/Defines$RequestPath;

    .line 114
    new-instance v0, Lio/branch/referral/Defines$RequestPath;

    const-string v1, "GetCredits"

    const/16 v2, 0x8

    const-string v3, "v1/credits/"

    invoke-direct {v0, v1, v2, v3}, Lio/branch/referral/Defines$RequestPath;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lio/branch/referral/Defines$RequestPath;->GetCredits:Lio/branch/referral/Defines$RequestPath;

    .line 115
    new-instance v0, Lio/branch/referral/Defines$RequestPath;

    const-string v1, "GetCreditHistory"

    const/16 v2, 0x9

    const-string v3, "v1/credithistory"

    invoke-direct {v0, v1, v2, v3}, Lio/branch/referral/Defines$RequestPath;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lio/branch/referral/Defines$RequestPath;->GetCreditHistory:Lio/branch/referral/Defines$RequestPath;

    .line 116
    new-instance v0, Lio/branch/referral/Defines$RequestPath;

    const-string v1, "CompletedAction"

    const/16 v2, 0xa

    const-string v3, "v1/event"

    invoke-direct {v0, v1, v2, v3}, Lio/branch/referral/Defines$RequestPath;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lio/branch/referral/Defines$RequestPath;->CompletedAction:Lio/branch/referral/Defines$RequestPath;

    .line 117
    new-instance v0, Lio/branch/referral/Defines$RequestPath;

    const-string v1, "IdentifyUser"

    const/16 v2, 0xb

    const-string v3, "v1/profile"

    invoke-direct {v0, v1, v2, v3}, Lio/branch/referral/Defines$RequestPath;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lio/branch/referral/Defines$RequestPath;->IdentifyUser:Lio/branch/referral/Defines$RequestPath;

    .line 118
    new-instance v0, Lio/branch/referral/Defines$RequestPath;

    const-string v1, "Logout"

    const/16 v2, 0xc

    const-string v3, "v1/logout"

    invoke-direct {v0, v1, v2, v3}, Lio/branch/referral/Defines$RequestPath;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lio/branch/referral/Defines$RequestPath;->Logout:Lio/branch/referral/Defines$RequestPath;

    .line 119
    new-instance v0, Lio/branch/referral/Defines$RequestPath;

    const-string v1, "GetReferralCode"

    const/16 v2, 0xd

    const-string v3, "v1/referralcode"

    invoke-direct {v0, v1, v2, v3}, Lio/branch/referral/Defines$RequestPath;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lio/branch/referral/Defines$RequestPath;->GetReferralCode:Lio/branch/referral/Defines$RequestPath;

    .line 120
    new-instance v0, Lio/branch/referral/Defines$RequestPath;

    const-string v1, "ValidateReferralCode"

    const/16 v2, 0xe

    const-string v3, "v1/referralcode/"

    invoke-direct {v0, v1, v2, v3}, Lio/branch/referral/Defines$RequestPath;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lio/branch/referral/Defines$RequestPath;->ValidateReferralCode:Lio/branch/referral/Defines$RequestPath;

    .line 121
    new-instance v0, Lio/branch/referral/Defines$RequestPath;

    const-string v1, "ApplyReferralCode"

    const/16 v2, 0xf

    const-string v3, "v1/applycode/"

    invoke-direct {v0, v1, v2, v3}, Lio/branch/referral/Defines$RequestPath;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lio/branch/referral/Defines$RequestPath;->ApplyReferralCode:Lio/branch/referral/Defines$RequestPath;

    .line 122
    new-instance v0, Lio/branch/referral/Defines$RequestPath;

    const-string v1, "DebugConnect"

    const/16 v2, 0x10

    const-string v3, "v1/debug/connect"

    invoke-direct {v0, v1, v2, v3}, Lio/branch/referral/Defines$RequestPath;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lio/branch/referral/Defines$RequestPath;->DebugConnect:Lio/branch/referral/Defines$RequestPath;

    .line 105
    const/16 v0, 0x11

    new-array v0, v0, [Lio/branch/referral/Defines$RequestPath;

    sget-object v1, Lio/branch/referral/Defines$RequestPath;->RedeemRewards:Lio/branch/referral/Defines$RequestPath;

    aput-object v1, v0, v4

    sget-object v1, Lio/branch/referral/Defines$RequestPath;->GetURL:Lio/branch/referral/Defines$RequestPath;

    aput-object v1, v0, v5

    sget-object v1, Lio/branch/referral/Defines$RequestPath;->RegisterInstall:Lio/branch/referral/Defines$RequestPath;

    aput-object v1, v0, v6

    sget-object v1, Lio/branch/referral/Defines$RequestPath;->RegisterClose:Lio/branch/referral/Defines$RequestPath;

    aput-object v1, v0, v7

    sget-object v1, Lio/branch/referral/Defines$RequestPath;->RegisterOpen:Lio/branch/referral/Defines$RequestPath;

    aput-object v1, v0, v8

    const/4 v1, 0x5

    sget-object v2, Lio/branch/referral/Defines$RequestPath;->RegisterView:Lio/branch/referral/Defines$RequestPath;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lio/branch/referral/Defines$RequestPath;->Referrals:Lio/branch/referral/Defines$RequestPath;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lio/branch/referral/Defines$RequestPath;->SendAPPList:Lio/branch/referral/Defines$RequestPath;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lio/branch/referral/Defines$RequestPath;->GetCredits:Lio/branch/referral/Defines$RequestPath;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lio/branch/referral/Defines$RequestPath;->GetCreditHistory:Lio/branch/referral/Defines$RequestPath;

    aput-object v2, v0, v1

    const/16 v1, 0xa

    sget-object v2, Lio/branch/referral/Defines$RequestPath;->CompletedAction:Lio/branch/referral/Defines$RequestPath;

    aput-object v2, v0, v1

    const/16 v1, 0xb

    sget-object v2, Lio/branch/referral/Defines$RequestPath;->IdentifyUser:Lio/branch/referral/Defines$RequestPath;

    aput-object v2, v0, v1

    const/16 v1, 0xc

    sget-object v2, Lio/branch/referral/Defines$RequestPath;->Logout:Lio/branch/referral/Defines$RequestPath;

    aput-object v2, v0, v1

    const/16 v1, 0xd

    sget-object v2, Lio/branch/referral/Defines$RequestPath;->GetReferralCode:Lio/branch/referral/Defines$RequestPath;

    aput-object v2, v0, v1

    const/16 v1, 0xe

    sget-object v2, Lio/branch/referral/Defines$RequestPath;->ValidateReferralCode:Lio/branch/referral/Defines$RequestPath;

    aput-object v2, v0, v1

    const/16 v1, 0xf

    sget-object v2, Lio/branch/referral/Defines$RequestPath;->ApplyReferralCode:Lio/branch/referral/Defines$RequestPath;

    aput-object v2, v0, v1

    const/16 v1, 0x10

    sget-object v2, Lio/branch/referral/Defines$RequestPath;->DebugConnect:Lio/branch/referral/Defines$RequestPath;

    aput-object v2, v0, v1

    sput-object v0, Lio/branch/referral/Defines$RequestPath;->$VALUES:[Lio/branch/referral/Defines$RequestPath;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;)V
    .locals 1
    .param p3, "key"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 126
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 124
    const-string v0, ""

    iput-object v0, p0, Lio/branch/referral/Defines$RequestPath;->key:Ljava/lang/String;

    .line 127
    iput-object p3, p0, Lio/branch/referral/Defines$RequestPath;->key:Ljava/lang/String;

    .line 128
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lio/branch/referral/Defines$RequestPath;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 105
    const-class v0, Lio/branch/referral/Defines$RequestPath;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lio/branch/referral/Defines$RequestPath;

    return-object v0
.end method

.method public static values()[Lio/branch/referral/Defines$RequestPath;
    .locals 1

    .prologue
    .line 105
    sget-object v0, Lio/branch/referral/Defines$RequestPath;->$VALUES:[Lio/branch/referral/Defines$RequestPath;

    invoke-virtual {v0}, [Lio/branch/referral/Defines$RequestPath;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lio/branch/referral/Defines$RequestPath;

    return-object v0
.end method


# virtual methods
.method public getPath()Ljava/lang/String;
    .locals 1

    .prologue
    .line 131
    iget-object v0, p0, Lio/branch/referral/Defines$RequestPath;->key:Ljava/lang/String;

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 136
    iget-object v0, p0, Lio/branch/referral/Defines$RequestPath;->key:Ljava/lang/String;

    return-object v0
.end method
