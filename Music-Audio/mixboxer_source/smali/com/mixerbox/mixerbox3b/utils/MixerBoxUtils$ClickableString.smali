.class Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$ClickableString;
.super Landroid/text/style/ClickableSpan;
.source "SourceFile"


# instance fields
.field private mListener:Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;


# direct methods
.method public constructor <init>(Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;)V
    .locals 0

    .prologue
    .line 1450
    invoke-direct {p0}, Landroid/text/style/ClickableSpan;-><init>()V

    .line 1451
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$ClickableString;->mListener:Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;

    .line 1452
    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 1456
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$ClickableString;->mListener:Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;

    invoke-virtual {v0, p1}, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;->onClick(Landroid/view/View;)V

    .line 1457
    return-void
.end method
