.class public final enum Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;
.super Ljava/lang/Enum;
.source "ShareManager_Old.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/utils/ShareManager_Old;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "SHARE_TYPE"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

.field public static final enum EMAIL_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

.field public static final enum EMAIL_SHARE_BODY:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

.field public static final enum EMAIL_SHARE_SUBJECT:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

.field public static final enum FB_DIALOG_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

.field public static final enum FB_MESSENGER_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

.field public static final enum FB_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

.field public static final enum INSTAGRAM_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

.field public static final enum PINTEREST_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

.field public static final enum SMS_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

.field public static final enum TM_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

.field public static final enum TW_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 55
    new-instance v0, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    const-string v1, "FB_SHARE"

    invoke-direct {v0, v1, v3}, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->FB_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    .line 56
    new-instance v0, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    const-string v1, "TW_SHARE"

    invoke-direct {v0, v1, v4}, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->TW_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    .line 57
    new-instance v0, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    const-string v1, "TM_SHARE"

    invoke-direct {v0, v1, v5}, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->TM_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    .line 58
    new-instance v0, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    const-string v1, "INSTAGRAM_SHARE"

    invoke-direct {v0, v1, v6}, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->INSTAGRAM_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    .line 59
    new-instance v0, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    const-string v1, "PINTEREST_SHARE"

    invoke-direct {v0, v1, v7}, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->PINTEREST_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    .line 60
    new-instance v0, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    const-string v1, "SMS_SHARE"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->SMS_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    .line 61
    new-instance v0, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    const-string v1, "FB_MESSENGER_SHARE"

    const/4 v2, 0x6

    invoke-direct {v0, v1, v2}, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->FB_MESSENGER_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    .line 62
    new-instance v0, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    const-string v1, "FB_DIALOG_SHARE"

    const/4 v2, 0x7

    invoke-direct {v0, v1, v2}, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->FB_DIALOG_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    .line 63
    new-instance v0, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    const-string v1, "EMAIL_SHARE"

    const/16 v2, 0x8

    invoke-direct {v0, v1, v2}, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->EMAIL_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    .line 64
    new-instance v0, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    const-string v1, "EMAIL_SHARE_BODY"

    const/16 v2, 0x9

    invoke-direct {v0, v1, v2}, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->EMAIL_SHARE_BODY:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    .line 65
    new-instance v0, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    const-string v1, "EMAIL_SHARE_SUBJECT"

    const/16 v2, 0xa

    invoke-direct {v0, v1, v2}, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->EMAIL_SHARE_SUBJECT:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    .line 54
    const/16 v0, 0xb

    new-array v0, v0, [Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    sget-object v1, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->FB_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    aput-object v1, v0, v3

    sget-object v1, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->TW_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    aput-object v1, v0, v4

    sget-object v1, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->TM_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    aput-object v1, v0, v5

    sget-object v1, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->INSTAGRAM_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    aput-object v1, v0, v6

    sget-object v1, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->PINTEREST_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->SMS_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->FB_MESSENGER_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->FB_DIALOG_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->EMAIL_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->EMAIL_SHARE_BODY:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    aput-object v2, v0, v1

    const/16 v1, 0xa

    sget-object v2, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->EMAIL_SHARE_SUBJECT:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    aput-object v2, v0, v1

    sput-object v0, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->$VALUES:[Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .prologue
    .line 54
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 54
    const-class v0, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    return-object v0
.end method

.method public static values()[Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;
    .locals 1

    .prologue
    .line 54
    sget-object v0, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->$VALUES:[Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    invoke-virtual {v0}, [Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    return-object v0
.end method
