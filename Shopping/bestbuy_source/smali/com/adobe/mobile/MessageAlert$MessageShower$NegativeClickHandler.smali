.class final Lcom/adobe/mobile/MessageAlert$MessageShower$NegativeClickHandler;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# instance fields
.field private final message:Lcom/adobe/mobile/MessageAlert;


# direct methods
.method public constructor <init>(Lcom/adobe/mobile/MessageAlert;)V
    .locals 0

    .prologue
    .line 189
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 190
    iput-object p1, p0, Lcom/adobe/mobile/MessageAlert$MessageShower$NegativeClickHandler;->message:Lcom/adobe/mobile/MessageAlert;

    .line 191
    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 2

    .prologue
    .line 196
    iget-object v0, p0, Lcom/adobe/mobile/MessageAlert$MessageShower$NegativeClickHandler;->message:Lcom/adobe/mobile/MessageAlert;

    invoke-virtual {v0}, Lcom/adobe/mobile/MessageAlert;->viewed()V

    .line 197
    iget-object v0, p0, Lcom/adobe/mobile/MessageAlert$MessageShower$NegativeClickHandler;->message:Lcom/adobe/mobile/MessageAlert;

    const/4 v1, 0x0

    iput-boolean v1, v0, Lcom/adobe/mobile/MessageAlert;->isVisible:Z

    .line 198
    return-void
.end method
